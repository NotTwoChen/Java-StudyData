package com.wsh.study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zyf on 2017/3/27.
 */
public class RegularExpressionDemo {

    //特点:正则表达式作为一个模板,将某个字符模式与所搜索的字符串进行匹配
    //普通字符:字母,数字,汉子,下划线,以及没有特殊定义的标点符号都是普通字符.
    //转义字符:\n \t \\等
    //标准字符集合:
	/*

	        \\d\\d\\d  "123"
	 * \d 任意一个数字 ,0-9中的任意一个
	 * \w 任意一个字母或数字或下划线,也就是A-Z,a-z,0-9,_中的任何一个字符
	 * \s 包括空格,制表符,换行符等空白字符中的任意一个
	 * . 小数点可以匹配除了\n以外的任何一个字符
	 * 注:区分大小写,大写是相反的意思(比如\D,就说明不是0-9中的任意一个)
	 * **/

    //自定义字符集合
	/*

	    [abc]  "d"
	 * []方括号匹配方式,能够匹配方括号中任意一个字符
	 * [ab5@]匹配字符a或b或5或@
	 * [^abc]匹配字符a,b,c之外的任意一个字符
	 * [f-k]匹配f-k之间的任意一个字母
	 * [^A-F0-3]匹配A-F,0-3之外的任意一个字符
	 * **/

    //修饰匹配次数的特殊符号(写在所修饰匹配内容的后面)
	/*
	 * {n}表达式重复n次
	 * {m,n}表达式至少重复m次,最多重复n次
	 * {m,}表达式至少重复m次
	 * ? 匹配表达式0次或者1次,相当于{0,1}
	 * + 表达式至少出现1次,相当于{1,}
	 * * 表达式不出现或出现任意次,相当于{0,}
	 * **/

    //字符边界
	/*
	 * ^ 与字符串开始的地方匹配
	 * $ 与字符串结束的地方匹配
	 * \b 匹配一个单词边界(??????没懂)
	 * 注:这里匹配的不是字符,是符合某种条件的位置(????待测)
	 * **/

    //选择符和分组
	/*
	 * 表达式		作用
	 * |		左右两边表达式之间"或"关系,匹配左边或右边
	 * ()		a,在被修饰匹配次数的时候,括号中的表达式可以作为整体被修饰
	 * 			b,去匹配结果的时候,括号中的表达式匹配到的内容可以被单独得到
	 * 			c,每一对括号会分配一个编号,使用()的捕获根据左括号的顺序从1开始自动编号(整个表达式的分组为编号0).
	 * **/

    //预搜索(断言)
    //断言，指在个人的语言中，轻易地在短时间内对某一件事情或者事物下的一种主观性非常强的言论.
    //从断言的表达形式可以看出，它用的就是分组符号，只不过开头都加了一个问号，
    // 这个问号就是在说这是一个非捕获组，这个组没有编号，不能用来后向引用，只能当做断言.
	/*
	 * 判断当前位置的前后字符,是否符合指定的条件,但不匹配前后的字符,是对位置的匹配.
	 * (?=exp)断言自身出现的位置的后面能匹配表达式exp(正先行断言)(出现在自身后面,那么自身就相对来说在前面,就叫先行)
	 * eg:哈哈哈go,要匹配哈哈哈后面是否出现go,如果匹配那么会得到
	 *      .{3}(?=go)
	 * (?<=exp)断言自身出现的位置的前面能匹配表达式exp(正后发断言)(出现在自身前面,那么自身就相对来说在后面,就叫后发)
	 * eg:go哈哈哈,要匹配哈哈哈前面是否出现go
	 *      (?<=go).{3}
	 * (?!exp)断言此位置的后面不能匹配表示exp
	 * (?<!exp)断言此位置的的前面不能匹配表达式exp
	 * **/

    public static void main(String[] args) {
        String chinese = "无敌dhdj";
        boolean isMatched;//转义字符\
        //汉字字符,只有.能匹配,无敌是两个,所以需要两个点
        isMatched = Pattern.matches("..\\w\\w\\w\\w",chinese);
        System.out.println("无敌汉字匹配:"+isMatched);
        //{n}
        isMatched = Pattern.matches(".*d.*d.*",chinese);
        System.out.println("重复:"+isMatched);
        //匹配电话号:1xx,xxxx,xxxx;
        String regexPhone = "[1][38]\\d([-]{0,1})\\d{4}([-]{0,1})\\d{4}";
        //可以将后面的xxxx看出一组,将这组重复两次
        //这就是()分组的作用
        regexPhone = "[1][38]\\d([-]{0,1}\\d{4}){2}";
        String phoneNumber = "13111111111";
        isMatched = Pattern.matches(regexPhone,phoneNumber);
        System.out.println("分组:"+isMatched);

        //编号是如何使用的?
        //示例:匹配"<body>你好~</body>"
        //分析,有两个标签,标签中的内容出现次数不定,出现字符内容不定
        //.表示除了\n之外的任意一个字符,*表示重复次数不定
        String regex1 = "<body>.*</body>";

        //发现有重复的body字段,可以优化
        //这个时候要注意,\1的语法,是在引用第1组的文本内容,注意是文本内容,不是在引用第一组的表达式
        //比如这里,(body)这是第一组,这组在匹配的时候会匹配到字符串body,那么\1在引用后,就得到了这个字符串
        //如果第一组为(\d),匹配到了3,那么\1引用后,得到的会是前面第一组匹配到的文本内容,也就是3

        //还要注意\1的语法,在字符串中要打\\1
        //这就叫 后向引用
        String regex2 = "<(body)>.*</\\1>";

        String bodyDemo = "<body>你sjlkdfjka好~</body>";
//        bodyDemo = "123.123.123.123";
//        regex2 = "(\\d{1,3})(.\\1){3}";

        isMatched = Pattern.matches(regex1,bodyDemo);
        System.out.println("编号demo1:"+isMatched);
        isMatched = Pattern.matches(regex2,bodyDemo);
        System.out.println("编号demo2:"+isMatched);




        String regexForward = "x(?=exp)";
        String forward = "xexp";
        //这个方法,只有全部匹配到才返回true,断言是不会全匹配到的,只能匹配到断言自身的内容
        isMatched = Pattern.matches(regexForward,forward);
        Pattern p = Pattern.compile(regexForward);
        Matcher matcher = p.matcher(forward);

        System.out.println("正先行断言:"+matcher.matches());

    }
}

