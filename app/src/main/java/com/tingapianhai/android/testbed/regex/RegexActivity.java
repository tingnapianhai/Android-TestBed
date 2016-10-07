package com.tingapianhai.android.testbed.regex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.tingapianhai.android.testbed.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);

        editText = (EditText) findViewById(R.id.edit_regex);
        editText.addTextChangedListener(textChangedListener);
    }

    private TextWatcher textChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            validateText(s.toString());
        }
    };

    private void validateText(String text){
        if(text == null || text.length() == 0) {
            return;
        }

//        a-ö üéáãé
//        0-9
//        The tab character, The newline (line feed), The carriage-return character, The form-feed character, The vertical tabulation (VT) character
//        “ [ ] - \ : % , @ _ / { } # ( ) ! ? ´ +
//
//                Utökningen i case-tjänsterna:
//
//        à À è È ì Ì ò Ò ù Ù ä Ä ë Ë ï Ï ö Ö ü Ü ÿ Ÿ â Â ĉ Ĉ ê Ê ĝ Ĝ ĥ Ĥ î Î ĵ Ĵ ô Ô ŝ Ŝ û Û ŷ Ŷ ã Ã ñ Ñ ĩ Ĩ õ Õ ũ Ũ ç Ç ķ Ķ ļ Ļ ņ Ņ ŗ Ŗ ş Ş ţ Ţ

        String validChars = "[a-z<E5><E4><F6>A-Z<C5><C4><D6><FC><E9><E1><E3><E9><DC><C9><C1>\u00e5\u00e4\u00f6\u00C5\u00c4\u0026\u0000/\\d\\s\"\\[\\]\\-\\\\:.%,@_/{}#()!?<B4>+]*";

        //String validStr1 = "[0-9a-öüéáãé “ [ ] - \\ : % , @ _ / { } # ( ) ! ? ´ +]";
        String validStr = "[a-zà-å0-9\u00f6\u00fc\uu00e9\u000b\t\n\r\f“ [ ] - \\ : % , @ _ / { } # ( ) ! ? ´ +]";
        Pattern pattern = Pattern.compile(validStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text.substring(text.length()-1));
        boolean rs = matcher.find();

        Log.v("regex", "regex:" + rs);

    }

}
