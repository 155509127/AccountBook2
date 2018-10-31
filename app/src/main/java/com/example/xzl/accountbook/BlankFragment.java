package com.example.xzl.accountbook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ListView listV;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
    public View onCreateView(final  LayoutInflater inflater,final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_blank, container, false);
        Button add=(Button) view.findViewById(R.id.btnadd);
        listV=(ListView) view.findViewById(R.id.list);
        final String PRODUCT = "product";
        final String PRICE = "price";
        final String CONFIGURATION = "configuration";

        String[] products = {"小米Note", "华为荣耀7", "魅族MX5", "锤子T1"};
        String[] prices = {"1999", "1999", "1999", "2480"};
        String[] configurations = {"高通骁龙 801，3GB RAM，16GB ROM", "麒麟 935，3GB RAM，16GB ROM", "联发科（MTK)Helio X10 Turbo，3GB RAM，32GB ROM", "高通骁龙 801，2GB RAM，32GB ROM"};
        List<Map<String, Object>> items = new ArrayList<>();

        for (int i = 0; i < products.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put(PRODUCT, products[i]);
            item.put(PRICE, prices[i]);
            item.put(CONFIGURATION, configurations[i]);
            items.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), items, R.layout.account, new String[]{PRODUCT, PRICE, CONFIGURATION}, new int[]{R.id.txtProduct, R.id.txtPrice, R.id.txtConfiguration});
        listV.setAdapter(adapter);




        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View resview=inflater.inflate(R.layout.add_dialog, null);
                final  Spinner spinner = (Spinner) resview.findViewById(R.id.spinner);
                ArrayAdapter<CharSequence> adaptersel = ArrayAdapter.createFromResource(resview.getContext(), R.array.select, android.R.layout.simple_spinner_item);
                adaptersel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adaptersel);
                //下拉列表选择事件监听器
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i>=0)
                            Toast.makeText(view.getContext(),adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                builder.setView(resview)
                        .setTitle("DATA")
                        // Add action buttons
                        .setPositiveButton(R.string.find, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //搜索

                                Float num=Float.valueOf(((TextView)resview.findViewById(R.id.textnum)).getText().toString());
                                /*Map<String, Object> item = new HashMap<>();
                                item.put(PRODUCT, products[i]);
                                item.put(PRICE, prices[i]);
                                item.put(CONFIGURATION, configurations[i]);*/
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                            }
                        }).create().show();

            }

        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

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
