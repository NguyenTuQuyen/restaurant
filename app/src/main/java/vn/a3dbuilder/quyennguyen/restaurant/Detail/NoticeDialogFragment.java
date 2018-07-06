package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import vn.a3dbuilder.quyennguyen.restaurant.R;

public class NoticeDialogFragment extends DialogFragment {
//    public interface NoticeDialogListener {
//        public void onDialogPositiveClick(NoticeDialogFragment dialog);
//        public void onDialogNegativeClick(NoticeDialogFragment dialog);
//    }
//    NoticeDialogListener mListener;
//    public void onAttach(ViewPagerDetail activity) {
//        super.onAttach(activity);
//        // Verify that the host activity implements the callback interface
//        try {
//            // Instantiate the NoticeDialogListener so we can send events to the host
//            mListener = (NoticeDialogListener) activity;
//        } catch (ClassCastException e) {
//            // The activity doesn't implement the interface, throw exception
//            throw new ClassCastException(activity.toString()
//                    + " must implement NoticeDialogListener");
//        }
//    }
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout to use as dialog or embedded fragment
//        return inflater.inflate(R.layout.add_rating, container, false);
//    }
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // The only reason you might override this method when using onCreateView() is
//        // to modify any dialog characteristics. For example, the dialog includes a
//        // title by default, but your custom layout might not need it. So here you can
//        // remove the dialog title, but you must call the superclass to get the Dialog.
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        // Build the dialog and set up the button click handlers
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setMessage(R.string.add_rating)
//                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // Send the positive button event back to the host activity
//                        mListener.onDialogPositiveClick(NoticeDialogFragment.this);
//                    }
//                })
//                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // Send the negative button event back to the host activity
//                        mListener.onDialogNegativeClick(NoticeDialogFragment.this);
//                    }
//                });
//        return builder.create();
//    }
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_rating, container, false);

        // Do all the stuff to initialize your custom view

        return v;
    }
}
