package com.tingapianhai.android.testbed.regex;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.tingapianhai.android.testbed.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexActivity extends AppCompatActivity {

    public static final String validCharsRegex ="[a-z<E5><E4><F6>A-Z<C5><C4><D6><FC><E9><E1><E3><E9><DC><C9><C1>\u00e5\u00e4\u00f6\u00C5\u00c4\u0026\u0000/\\d\\s\"\\[\\]\\-\\\\:.%,@_/{}#()!?<B4>+]*";
    public static final String validChars = "1234567890 abcdefghijklmnopqrstuvwxyzäåö ABCDEFGHIJKLMNOPQRSTUVWXYZÄÅÖ “[]-\\:%,@_/{}#()!?´";
    public String invalidChars = "";

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);

        editText = (EditText) findViewById(R.id.edit_regex);
        editText.addTextChangedListener(textChangedListener);

        textView = (TextView) findViewById(R.id.textview_regex);
        textView.setText(getColorfulText("", Color.RED));
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
//            validateTextByRegex(s.toString());
//            validateTextByRegex2(s.toString());
            //validateText(s.toString());
            validateUrl(s.toString());
        }
    };

    private void validateTextByRegex(String text){
        if(text == null || text.length() == 0) {
            return;
        }

        String lastChar = text.substring(text.length()-1);

//        a-ö üéáãé
//        0-9
//        The tab character, The newline (line feed), The carriage-return character, The form-feed character, The vertical tabulation (VT) character
//        “ [ ] - \ : % , @ _ / { } # ( ) ! ? ´ +
//
//                Utökningen i case-tjänsterna:
//
//        à À è È ì Ì ò Ò ù Ù ä Ä ë Ë ï Ï ö Ö ü Ü ÿ Ÿ â Â ĉ Ĉ ê Ê ĝ Ĝ ĥ Ĥ î Î ĵ Ĵ ô Ô ŝ Ŝ û Û ŷ Ŷ ã Ã ñ Ñ ĩ Ĩ õ Õ ũ Ũ ç Ç ķ Ķ ļ Ļ ņ Ņ ŗ Ŗ ş Ş ţ Ţ

        //String validStr1 = "[0-9a-öüéáãé “ [ ] - \\ : % , @ _ / { } # ( ) ! ? ´ +]";
        String validStr = "[a-zà-å0-9\u00f6\u00fc\u00e9\u000b\t\n\r\f\u005c\u0022[ ]-:%,@_/{}#()!?´+]";
        Pattern pattern = Pattern.compile(validCharsRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
//        boolean rs = matcher.find();
//        String test = Pattern.quote(validStr);

        Log.v("regex", "regex: find:" +  matcher.find() );

//        while (matcher.find()) {
//            Log.v("regex", "regex:" + matcher.group());
//        }

    }

    private void validateTextByRegex2(String text){
        if(text == null || text.length() == 0) {
            return;
        }

        String lastChar = text.substring(text.length()-1);

        String validStr = "[a-zà-å0-9\u00f6\u00fc\u00e9\u000b\t\n\r\f\u005c\u0022[ ]-:%,@_/{}#()!?´+]";
        Pattern pattern = Pattern.compile(validCharsRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        String test = matcher.replaceAll("");

        String test2 = text.replaceAll("[^"+ validCharsRegex +"]","");//get the common characters

        Log.v("regex", "regex:match:" + matcher.matches() + " " + test);
    }

    private void validateText(String text) {
        if(text == null || text.length() == 0) {
            return;
        }

        String lastChar = text.substring(text.length()-1);

        String validChars =
                "abcdefghijklmnopqrstuvwxyzäåö" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÅÖ"
                ;

//        if( lastChar.equals("\uu0040")) {
//            Log.v("regex", "regex @:" + "\uu0040");
//        } else if(lastChar.equals("\uu0023")) {
//            Log.v("regex", "regex:" + "\uu0023");
//        }

        if(text.contains("\uu0040") || text.contains("\uu0023")) {
            Log.v("regex", "regex-:" + "\uu0040" + " " + "\uu0023");
        } else {
            Log.v("regex", "regex-:" + "no");
        }

    }

    private void validateUrl(String text) {
        if(text == null || text.length() == 0) {
            return;
        }

        String regex = "^\\w+://.*";

        boolean matches = text.toLowerCase().matches(regex);
        Log.v("regex", "regex-:" + matches);

    }

    private Spannable getColorfulText(String message, int color) {

        String text = "0123456789012345";

        Spannable spannable = new SpannableString(text);

        spannable.setSpan(new ForegroundColorSpan(color), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannable;
    }

    private boolean isValidMessage(String message) {
        invalidChars = "";
        for(int i = 0; i<message.length(); i++) {
            if ( validChars.indexOf( message.charAt(i) ) == -1 ) {
                invalidChars = invalidChars + message.charAt(i);
            }
        }

        if(invalidChars.length()>0) return false;

        return true;
    }

    private boolean isValidMessage2(String message) {
        invalidChars = "";
        Pattern pattern = Pattern.compile(validCharsRegex);
        Matcher matcher = pattern.matcher(message);
        invalidChars = matcher.replaceAll("");
        return matcher.matches();
    }

}
