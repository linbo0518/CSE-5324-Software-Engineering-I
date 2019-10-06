package com.newscenter.android.util;

import android.app.Activity;
import android.util.Xml;
import android.widget.Toast;

import com.newscenter.common.StringUtil;
import com.newscenter.domain.model.SubscriptionModel;
import com.newscenter.model.Subscription;
import com.google.common.base.Strings;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.team7.feeder.R;

import static com.newscenter.common.XMLUtil.skip;

/**
 * @description:
 * @author: Match
 * @date: 12/17/16
 */

public class OPMLHelper {
    private static final String OPML = "opml";
    private static final String BODY = "body";
    private static final String OUTLINE = "outline";
    private static OPMLHelper sInstance;

    public static OPMLHelper getInstance() {
        if (sInstance == null) {
            sInstance = new OPMLHelper();
        }
        return sInstance;
    }

    public void add(String filePath, Activity activity, Long accountId) {
        if (Strings.isNullOrEmpty(filePath)) {
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            parser.nextTag();
            List<Subscription> subscriptionList = readOPML(parser, accountId);
            SubscriptionModel.getInstance().insert(subscriptionList);

            StatManager.statEvent(activity, StatManager.EVENT_IMPORT_OPML_SUCCESS);
            Toast.makeText(activity, R.string.import_success, Toast.LENGTH_SHORT).show();
        } catch (XmlPullParserException e) {
            StatManager.uploadFile("OPMLFailed", file);
            StatManager.statEvent(activity, StatManager.EVENT_IMPORT_OPML_FAILED);
            Toast.makeText(activity, R.string.import_failed_format, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            StatManager.uploadFile("OPMLFailed", file);
            StatManager.statEvent(activity, StatManager.EVENT_IMPORT_OPML_FAILED);
            Toast.makeText(activity, R.string.import_failed, Toast.LENGTH_SHORT).show();
        }
    }

    private List<Subscription> readOPML(XmlPullParser parser, Long accountId) throws IOException, XmlPullParserException {
        List<Subscription> subscriptionList = new ArrayList<>();
        parser.require(XmlPullParser.START_TAG, null, OPML);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals(BODY)) {
                subscriptionList.addAll(readBody(parser, accountId));
            } else {
                skip(parser);
            }
        }
        return subscriptionList;
    }

    private List<Subscription> readBody(XmlPullParser parser, Long accountId) throws IOException, XmlPullParserException {
        List<Subscription> subscriptionList = new ArrayList<>();
        parser.require(XmlPullParser.START_TAG, null, BODY);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals(OUTLINE)) {
                subscriptionList.addAll(readOutline(parser, accountId));
            } else {
                skip(parser);
            }
        }
        return subscriptionList;
    }

    private List<Subscription> readOutline(XmlPullParser parser, Long accountId) throws IOException, XmlPullParserException {
        List<Subscription> subscriptionList = new ArrayList<>();
        String type = parser.getAttributeValue(null, "type");
        if (StringUtil.equals(type, "rss")) {
            subscriptionList.add(parseSubscription(parser, accountId));
            parser.nextTag();
        } else {
            parser.require(XmlPullParser.START_TAG, null, OUTLINE);
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();
                // Starts by looking for the entry tag
                if (name.equals(OUTLINE)) {
                    subscriptionList.addAll(readOutline(parser, accountId));
                } else {
                    skip(parser);
                }
            }
        }
        return subscriptionList;
    }

    private Subscription parseSubscription(XmlPullParser parser, Long accountId) {
        String text = parser.getAttributeValue(null, "text");
        String title = parser.getAttributeValue(null, "title");
        String xmlUrl = parser.getAttributeValue(null, "xmlUrl");
        String htmlUrl = parser.getAttributeValue(null, "htmlUrl");
        // may be null
        String description = parser.getAttributeValue(null, "description");

        String iconUrl;
        if (!Strings.isNullOrEmpty(htmlUrl)) {
            if (htmlUrl.endsWith("/")) {
                htmlUrl = htmlUrl.substring(0, htmlUrl.length() - 2);
            }
        }
        iconUrl = htmlUrl + "/favicon.ico";

        Subscription subscription = new Subscription(
                null,
                "feed/" + xmlUrl,
                title,
                iconUrl,
                xmlUrl,
                null,
                htmlUrl,
                description,
                "",
                "",
                0L,
                0L,
                accountId,
                "",
                "",
                ""
        );
        return subscription;
    }
}
