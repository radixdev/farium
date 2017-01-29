package com.radix.farium;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LinkReceiver extends BroadcastReceiver {
  private static final String TAG = LinkReceiver.class.getName();
  public static final String CLIPBOARD_CONTENTS_KEY = "t";

  @Override
  public void onReceive(Context context, Intent intent) {
    // Read the intent
    Bundle extras = intent.getExtras();

    // Set to clipboard
    if (extras.containsKey(CLIPBOARD_CONTENTS_KEY)) {
      String textToCopy = extras.getString(CLIPBOARD_CONTENTS_KEY);

      // Gets a handle to the clipboard service.
      ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
      ClipData clip = ClipData.newPlainText("text from farium", textToCopy);

      clipboard.setPrimaryClip(clip);
      Log.d(TAG, String.format("Set '%s' as the clipboard text", textToCopy));
    }
  }
}
