# MyCalculator

## MainActivity.java
1. 숫자와 id 배열을 만들고 for문을 사용하여 각각의 숫자 버튼에 id를 넣음
``` Java
Button btnNum[] = new Button[10];
int btnId[] = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
                    R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
for (int i=0; i<btnNum.length; i++)
{
    btnNum[i] = (Button)findViewById(btnId[i]);
}
```
------------
2. Click이라는 OnClickListener를 만들고 for문을 통해 각각의 숫자 버튼에 적용함
``` Java
View.OnClickListener Click = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String text = (String) textView1.getText();
        text += ((Button) v).getText();

        textView1.setText(text);
    }
};

for (int i=0; i<btnNum.length; i++)
{
     btnNum[i].setOnClickListener(Click);
}
```
-------------
3. 사칙연산 버튼
``` Java
btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String text = (String) textView1.getText();
        num1 = Integer.parseInt(text);
        textView1.setText("");
        operator = 1;
    }
});
```
text 변수에 textView1의 값을 넣고 text를 Integer로 변환하여 num1에 넣음

operator 값
+ add는 1, sub는 2, mul는 3, div는 4
-------------
4. Equal 버튼
``` Java
btnEqual.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        num2 = Integer.valueOf(textView1.getText().toString());
        if (operator == 1) {
            result = num1 + num2;
            addList(num1 + " + " + num2 + " = " + result.toString());
        } else if (operator == 2) {
            result = num1 - num2;
            addList(num1 + " — " + num2 + " = " + result.toString());
        } else if (operator == 3) {
            result = num1 * num2;
            addList(num1 + " × " + num2 + " = " + result.toString());
        } else if (operator == 4) {
            result = num1 / num2;
            addList(num1 + " ÷ " + num2 + " = " + result.toString());
        }
        textView1.setText(String.valueOf(result));
    }
});
```
textView1 값을 num2에 저장하고 조건문을 통해 operator 값에 따라 더하기, 빼기, 곱하기, 나누기를 함

나눈 값은 list에 저장되고 textView1에 출력됨

-----------
5. C, 기록 버튼
``` Java
btnClean.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        result = 0;
        textView1.setText("");
    }
});

// activity 전환
btnRecode.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), RecodeActivity.class);
        startActivity(intent);
    }
});
```
btnClean을 누르면 result값과 textView1를 초기화함

btnRecode를 누르면 startActivity로 recode_activity를 실행함


## RecodeActivity.java
``` Java
1. Adaptor 생성 및 list 값 listView에 적용
ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ((MainActivity)MainActivity.context_main).list);
listView.setAdapter(adapter);
```
--------
2. 초기화, 계산기 버튼
``` Java
btnListClear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ((MainActivity)MainActivity.context_main).list.clear();
        adapter.notifyDataSetChanged();
    }
});

btnMain.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
```
btnListClear을 누르면 MainActivity의 list의 값을 초기화하고 notifyDataSetChanged()를 사용하여 업데이트함

btnMain을 누르면 현재 activity 창이 닫히고 그 전 창인 activity_main으로 이동함

