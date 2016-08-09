package edu.asu.msse.anmurth1.sdkscanner;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Copyright 2015 Aditya Narasimhamurthy.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author: Aditya Narasimhamurthy  aditya.murthy@asu.edu
 * @version: August 08, 2016
 */
public class ProgressActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result1);

        TextView tv = (TextView) findViewById(R.id.textView);

        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "V.text");

        if(file.exists()){
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + '\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            tv.setText(sb);
        }

        else{
            tv.setText("No file found");
        }
    }
}
