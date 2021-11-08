package vn.edu.usth.moodlenew;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyCoursesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCoursesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public MyCoursesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyCoursesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyCoursesFragment newInstance(String param1, String param2) {
        MyCoursesFragment fragment = new MyCoursesFragment();
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

        // code clickable for courses
        View view = inflater.inflate(R.layout.fragment_my_courses, container, false);
        LinearLayout mobileapp = (LinearLayout) view.findViewById(R.id.mobileapp);
        LinearLayout webapp = (LinearLayout) view.findViewById(R.id.webapp);




        mobileapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Onclick","Onclick");

                Intent intent = new Intent(getActivity(), MyCoursesFragment_MobileAppActivity.class);
                startActivity(intent);
                
            }
        });

        webapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Onclick","Onclick");

                Intent intent = new Intent(getActivity(), MyCoursesFragment_WebAppActivity.class);
                startActivity(intent);

            }
        });

        // Inflate the layout for this fragment
        return view;

    }



}