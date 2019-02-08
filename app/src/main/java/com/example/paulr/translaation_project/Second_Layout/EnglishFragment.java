package com.example.paulr.translaation_project.Second_Layout;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paulr.translaation_project.First_Layout.AsyncTask_DB_Test;
import com.example.paulr.translaation_project.First_Layout.MainActivity;
import com.example.paulr.translaation_project.R;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

import androidx.fragment.app.Fragment;


public class EnglishFragment extends Fragment  {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private TextView  WordE;
    private TextView defEnglish;

    private String wordEnglish;


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EnglishFragment() {

    }


    public static EnglishFragment newInstance(String param1, String param2) {
        EnglishFragment fragment = new EnglishFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_english, container, false);

        TextView WordE =v.findViewById(R.id.WordEnglish);
        TextView defEnglish = v.findViewById(R.id.BackgroundEnglish);
        WordE.setText(mParam1);
        defEnglish.setText(mParam2);


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   // @Override
   // public void onAttach(Context context) {
    //    super.onAttach(context);
   //     if (context instanceof OnFragmentInteractionListener) {
      //      mListener = (OnFragmentInteractionListener) context;
      //  } else {
      //      throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
       // }
   // }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
