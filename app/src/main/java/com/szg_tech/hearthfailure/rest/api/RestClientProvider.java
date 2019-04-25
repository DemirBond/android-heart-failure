package com.szg_tech.hearthfailure.rest.api;

import android.content.Context;
import android.content.Intent;

import com.szg_tech.hearthfailure.activities.authentication.AuthenticationActivity;
import com.szg_tech.hearthfailure.storage.PreferenceHelper;
import com.szg_tech.hearthfailure.storage.entities.Credentials;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class RestClientProvider {

    private static RestClient restClient;

    public static RestClient get(Context context) {
        if (restClient == null) {
            if (context == null || context.isRestricted()) {
                throw new IllegalStateException("Call init before getting restClient");
            }
            Credentials credentials = PreferenceHelper.getCredentials(context);
            if (!credentials.getToken().isEmpty()) {
                Intent intent = new Intent(context, AuthenticationActivity.class);
                context.startActivity(intent);
            } else {
                init(credentials.getToken());
            }
        }
        return restClient;
    }

    public static void init(String token) {
        restClient = new RestClient(token);
    }

}
