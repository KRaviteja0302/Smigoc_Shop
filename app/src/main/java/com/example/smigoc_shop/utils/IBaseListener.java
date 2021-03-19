package com.example.smigoc_shop.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smigoc_shop.views.fragments.ProgressDialogFragment;
import com.google.android.material.snackbar.Snackbar;


public interface IBaseListener {

    default void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    default void showToast(Context context, int stringId) {
        Toast.makeText(context, stringId, Toast.LENGTH_SHORT).show();
    }

    default void alertMessage(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        alertMessage(context, "ALERT!!", message, null, null, onClickListener, null);
    }

    default void alertMessage(Context context, String message, String ok, DialogInterface.OnClickListener onClickListener) {
        alertMessage(context, "ALERT!!", message, ok, null, onClickListener, null);
    }

    default void alertMessage(Context context, String title, String message, String ok, DialogInterface.OnClickListener onClickListener) {
        alertMessage(context, title, message, ok, null, onClickListener, null);
    }

    default void alertMessage(Context context, String title, String message, String ok, String cancel, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListenerCancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(ok == null ? "Ok" : ok, onClickListener);
        if (cancel != null && onClickListenerCancel != null)
            builder.setNegativeButton(cancel, onClickListenerCancel);
        builder.show();
    }



    default void showLoader(FragmentManager fragmentManager) {

        ProgressDialogFragment fragment = ProgressDialogFragment.getInstance();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment prev = fragmentManager.findFragmentByTag("load");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        fragment.show(ft, "load");
    }

    default void hideLoader(FragmentManager fragmentManager) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ProgressDialogFragment prev = (ProgressDialogFragment) fragmentManager.findFragmentByTag("load");
        if (prev != null) {
            ft.remove(prev);
            prev.dismiss();
        }
    }

    default void navigateNext(Context context, Class activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    default void navigateNext(Context context, Class activity, boolean clear) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        if (clear) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    default void showSnackBar(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
