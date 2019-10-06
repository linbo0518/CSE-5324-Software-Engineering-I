package com.newscenter.android.util;

import android.content.Context;

import com.newscenter.android.htmltextview.HtmlTextView;
import com.newscenter.android.other.HtmlImageGetterEx;
import com.newscenter.model.Article;
import com.google.common.base.Strings;

/**
 * @description:
 * @author: Match
 * @date: 1/27/17
 */

public class ArticleUtil {

    // TODO: 1/27/17 context manager
    public static void setContent(Context context, Article article, HtmlTextView textView, String subscriptionName) {
        if (article == null || textView == null) {
            return;
        }

        try {
            if (Strings.isNullOrEmpty(article.getContent())) {
                if (!Strings.isNullOrEmpty(article.getDescription())) {
                    textView.setHtml(article.getDescription(), new HtmlImageGetterEx(textView, null, true));
                }
            } else {
                textView.setHtml(article.getContent(), new HtmlImageGetterEx(textView, null, true));
            }
        } catch (IndexOutOfBoundsException e) {
            StatManager.statEvent(context, StatManager.EXCEPTION_SET_HTML,
                    "subscription=" + subscriptionName + ", desc=" + article.getDescription());
        } catch (RuntimeException e) {
            StatManager.statEvent(context, StatManager.EXCEPTION_PARSE_HTML,
                    "subscription=" + subscriptionName + ", desc=" + article.getDescription()
                            + ", message=" + e.getMessage());
        }
    }

    public static String getContent(Article article) {
        if (!Strings.isNullOrEmpty(article.getContent())) {
            return article.getContent();
        }
        return article.getDescription();
    }
}
