//package com.example.masssportsnews.fragments;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//
//import androidx.activity.result.ActivityResultLauncher;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import com.example.masssportsnews.R;
//import com.journeyapps.barcodescanner.CaptureActivity;
//import com.journeyapps.barcodescanner.ScanContract;
//import com.journeyapps.barcodescanner.ScanOptions;
//
//
//public class ScannerFragment extends Fragment {
//
//    Button btnScan;
//
//    public ScannerFragment() {
//        // Required empty public constructor
//    }
//
//    public static ScannerFragment newInstance(String param1, String param2) {
//        ScannerFragment fragment = new ScannerFragment();
//        Bundle args = new Bundle();
//
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        return inflater.inflate(R.layout.fragment_scanner, container, false);
//    }
//
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
//    {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        btnScan = view.findViewById(R.id.btnScan);
//        btnScan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                codeScanner();
//            }
//        });
//
//        codeScanner();
//    }
//
//    private void codeScanner()
//    {
//        ScanOptions options = new ScanOptions();
//        options.setPrompt("Volume up to flash on");
//        options.setBeepEnabled(true);
//        options.setOrientationLocked(true);
//        options.setCaptureActivity(CaptureAct.class);
//
//        barLauncher.launch(options);
//    }
//
//    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result ->
//    {
//        if(result.getContents() != null)
//        {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//            builder.setTitle("Result");
//            builder.setMessage(result.getContents());
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                }
//            }).show();
//        }
//
//    });
//}