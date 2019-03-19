package com.jk.utils;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {


	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092700610284";

	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCqNLE3stY4l+kQqvlMw55H1v+KA4tugD4l2cmhIHEGLJ8rJgebBlxfSV2AWtfdKUbLG4e9XW0Bxre6V4UOToYNcRqRnRboNFGFEHydTXLYgrrXw1BznWjgUpYAjizvzMLKWuD39/vKzif/4yyG1iTrnb30v7Un4/n61adkaQUcbRjcvOERKM/mW9cKBJPqhr8HtPBsUkenVjCjTsr4oZgP9DR7wEeu8vVDbWrvY1fxyuU8MQ8NU0Iw+Xff9qEOLc2REyIogwRbgXlIZksDrves9qaZ76FbyiNNi+7JYXe2g7MPVBnvWr7tRoMpEeKaXt7utfmdCGEKnK7S90ySeR/3AgMBAAECggEBAKDghzVHU1ZQt9mqUVNuftgWbpkL+qmqi5OJRByJJmuYl6XYH043d+4U0Uz2EJ0ZW7G0xtuFR/hq1NRLzxcTv39LDbreyX0XnonwaGjigJAHGQXBtfRhr3SAewnxWKYcW22a8pNPEO7DZ2llV3vnQyR1h8ujvF4FDQ47DipJXaxcH3dZ+nqNygWuYwsgN7aY56U/qXo973T/W8d//StAGxyyyzT9Tgu4RV3NvUt1i04GlQYaW+y2lkKTtNqr6y32VquDYODLlvlYaU+vQ1QgoUqKYxv5ZPdIA8VtqrOOJqrwG+ABQ6DroMognd+1Ao5rSh6UZtUfj4Z1V7Ig8/p8tVECgYEA8QaUIibfOHL4ONy2kFJpJdalsvEPjw3Dwez4rhZf/bJdAeeIbroj6FT1VQovm6qO0v9mzy1Z/JAT/vur75GdftVP15/fP+XSX2l0uxrGP/4FOYQFyhY0ylOTNxrDk+DHVpr/OdQKQltgmmIiC2cB+xVObmHlkTfEffAwXZW+/E8CgYEAtMfAMG8fqbpL2QU1Tig4YrONZnH390jxniGkkcBb1fsGsaw5DueIg2UfX2PxwPdtt5aIvOSSQI+mmHfYuO0Jff/ud8xo726IZ2VQ3+A7BclaMyGbXYcqTmtyBAuQ3e7cAHoDcB9I7MpLm1IbISp4TMy19tkymrOq/8/u9VIhb9kCgYAxQljwCeXBEa4tYN5m7JDUzOOciKvXXsbNUXMZkTUZEmTzyLAXgS9pgkOJl8VXGSqLcOtAGFK1zXRovmLLWYVIsKvas6/azUuLeHAE9VnjJjVHJfZQ8OzlFOOXdX7XMC9NQew7k1xtZ2N86eVvUyQSfq5C3PsgDLe5zWb1GW+o/QKBgD/eeqYh/HvIl9d6oZSVXSZx7TkOdt7k5IhLtorP/SIiaAEJqbb8Uhyp82WON/FG+XptMq4ZyxoIJoGjhev/wuTDMQseKsy8rnBpOSN/YxruQnHiI7PtdyLxjvyi4XGnXA7HDMPmKauO5Rtg7LjQ+mOXx4oIvnotk/KBEhmWBL4xAoGAIpwmplfI1XiLiM3vtuRt3SqY5oNGUXT3uEjMw8r/SVkMJaDDS+R3aTRMd4oTMQyovYRqZ0l9KlT4CxFOXx4zKSqkTZpg2voSRS14cLWmH4nTHBwY4LY1lyS/SdhID5pUX0PmwiM7uK/Enbt3W4eahyOand6q3a0KgORTacB8ATc=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1JbEqBtFy+tcLJfCphBPQIahpBeX3WZLz5Ui6TxIj6bWjkO4RicqllkwEIdXF6dV4BCUhn08ANe6iX08g4o3oWEFApAEkHu41wTLASabAXVZkhGJyzpZ6XxX49iEeUxqVCw3vkawRq29GuzSL/Ou3gYSJAKVJZVXd85WwIrRuRDb1XRy2GYgqLwSFOwoSjIX2hYLWqmBs/jQBLFWbXXabpTrwvbLMmV3Pl3pTT0fyGSbfDS1zjuv7ZEWfqCIPnDRe+4gjpc7Qp1QhLFWPH0nyUs5mm1MkfUfuK1fCGl2UXPaHd0eFwAhYZRslmaB25T5MnMAvZIgaBTCKonjF0wXxwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:3001/good/toError";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8082/cspecialist/toPage1";

	public static String return_url02 = "http://localhost:8082/cspecialist/toJiFenList";

	public static String return_url03 = "http://localhost:8082/cspecialist/toVip";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "D:";



    /**
     *  写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *  @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

