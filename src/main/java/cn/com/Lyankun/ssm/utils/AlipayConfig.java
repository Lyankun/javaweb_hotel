package cn.com.Lyankun.ssm.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：  ksfxhw3818@sandbox.com   111111
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000118645319";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYyMSy2+1eiMn8McMwR29pU5wB1gKHFmxWbTckrU+VSWmCZIMWXB0xEU+1fEpwGqbIILWbuhzksuFOaI5xLGgTLm2W9zxA/6I+VnHmWoAWRb925k8jHaKwozO1VSpmBzhn9NM1Ce8opVK1t27jcmPtZZ+gM5WyUfSoiVAMhshygOEEJzWDhUNmAWuyCHLqktiXUkG54d9nDbPvINEWbdZtYujJk0biaMJnLNtwRfMwLG8UTZ1yXARaPvFBnDU1tZL9TX3nKwwWPAaClvHmH+eR6VFcEsqyW1xkBITwrtv0nWWmhLUQBb9XrZ48QaqhC4eUBPSqmW9EUKTJ+Lz+GkfTAgMBAAECggEAJnmoz0IDLONVumTtuqLCs8uSZgP27v3+mmU2lc3vVLEAGQ4m1OKtl0W8xP9f34tWpN9X3Lepvw4tHwnFlUqRiwMOJg5s5hF6UiiC1nfD+dfmt5KYK0ezSLhQtUGVQ8xdsBA/gAPYbmvzwD9JdY3BDG+jGzziXd21txudRQpMQEk/NFOJIBybvSbLKZ1ZoSYY6NEKj3y7oG5RgnrWv93yUXz4ra2/HDvMimmsGGPcn+sFFSs1BbF5B2/llH2jvCXcqJoS4yjp6g7EYu2DwMo/W/VyIMZs1EZcNmJSG1eXqFl/fWJ4xUKH5kzqjNrXQxkNmBDGhF9Cnj6nvS0+Ex+0gQKBgQDsF6240EQF/Tg9izgDW+/aALyJzqhxe3tmuSX0D2vAezB+fludohI//kQHiba1SbxJxyH+LAEIqxhbs1kJ7bWkFY//UqXsmnCxZgOXYmK/ekf3qWWhpWvfZLGygwbn5Mwg6qr7cd/AwDFfZLRqzUo9TJk4XR3rgVxojsjZWNam2QKBgQClqsmwg4PRLK+8mhY/rmiEAMbOXwMnO3S84WgLZT6buZ9VZ8hmtS/H7bb3W9OJyQizQj7yRx+QNQfbGk+y4pevJW7kAWm+hbYDTyzf8FmCVZnvQV9kcsPM9mlmIg7nCHpoPb5UXRLN72QomirH/LNB0szrv+3RezWpnsFGC00wiwKBgQCVDsoWsh8QbPQyHxCpRkVjrS1cEEbXBzA9Bc5Jjebo6p4ObvamymmdT4ph+/eH89rV9cynbd7lOyiw1MX1d8hDpX15pROvEz7tMcw4qtxPqgOAAMpyyT8XFrr+Sq10gUbDzYVQJXAwgOdrI+iouZ4Sn6bpKBk41D6koOl8GBPF2QKBgCIRVfqDgQbx3o21Th/4WKvUkQ19QmO9+UqiO8gkINTbPiXM+swMNHAztS1257Bs8+oRFGq0L4xzK1NmPL93k2PEGeKvW7R/QKe7j2nZvj5sJgSqd9hrNVKf1ZrYJCJkfu+SyuIEZcqNkRY8ZdHMaHx/wf408M3kPWvNJselqVDzAoGBALsCj08fzjJAulDkhiUPR//i5T/f2xdpJcpsnHAyPPSn/F4KsbcM0lg5Yu9pbwDZ3vi0o0MiULqLY0GEP4HL+JLLCAerwjjy725LGkMlaYt6DHCucgLMTK15dJxRhbu5TfhMYSoUCuOi0TAuNB0PEjf6k5yOWjdoSmnZA3EJJ9Z0";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmMjEstvtXojJ/DHDMEdvaVOcAdYChxZsVm03JK1PlUlpgmSDFlwdMRFPtXxKcBqmyCC1m7oc5LLhTmiOcSxoEy5tlvc8QP+iPlZx5lqAFkW/duZPIx2isKMztVUqZgc4Z/TTNQnvKKVStbdu43Jj7WWfoDOVslH0qIlQDIbIcoDhBCc1g4VDZgFrsghy6pLYl1JBueHfZw2z7yDRFm3WbWLoyZNG4mjCZyzbcEXzMCxvFE2dclwEWj7xQZw1NbWS/U195ysMFjwGgpbx5h/nkelRXBLKsltcZASE8K7b9J1lpoS1EAW/V62ePEGqoQuHlAT0qplvRFCkyfi8/hpH0wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	/*public static String return_url = "http://localhost/javaweb_hotel-1.0-SNAPSHOT/orders/afterOrdersPays";//本地部署打包路径*/
     public static String return_url = "http://localhost:8080/orders/afterOrdersPays";
   /* public static String return_url =  "http://47.110.147.119/javaweb_hotel-1.0-SNAPSHOT/orders/afterOrdersPay";*/

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
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

