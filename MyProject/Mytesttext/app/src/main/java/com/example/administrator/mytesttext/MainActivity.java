package com.example.administrator.mytesttext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Content;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Content=(TextView)findViewById(R.id.Content);
        input = "上海联通于1月10日至11日在青浦景苑会议中心召开了2017年度工作会议暨二届三次职工代表大会。大会贯彻落实了集团公司2017年度工作会议精神，全面回顾了2016年各项工作成果，对新一年的目标和任务进行了安排和部署，组织和动员全体干部员工进一步坚、团结一致，为推动上海联通稳步健康发展续写新的篇章。公司领导班子全体、二级副以上中层干部和广大的职工代表共计200余人参加了会议。";
        String cc = ToSBC(input);
        Content.setText(cc);
    }
    public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

}
