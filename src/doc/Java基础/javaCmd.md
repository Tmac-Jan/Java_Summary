> ## Java调用控制台命令&Java Runtime
- Java-Runtime类
   > Runtime 类代表着Java程序的运行时环境，每个Java程序都有一个Runtime实例，该类会被自动创建，我们可以通过Runtime.getRuntime() 方法来获取当前程序的Runtime实例。
  - 常用方法
    - 获取当前Jvm的内存信息
    ```java
          /*
           * 获取当前jvm的内存信息,返回的值是 字节为单位
           * */
          public static void getFreeMemory() {
              //获取可用内存
              long value = Runtime.getRuntime().freeMemory();
              System.out.println("可用内存为:"+value/1024/1024+"mb");
              //获取jvm的总数量，该值会不断的变化
              long  totalMemory = Runtime.getRuntime().totalMemory();
              System.out.println("全部内存为:"+totalMemory/1024/1024+"mb");
              //获取jvm 可以最大使用的内存数量，如果没有被限制 返回 Long.MAX_VALUE;
              long maxMemory = Runtime.getRuntime().maxMemory();
              System.out.println("可用最大内存为:"+maxMemory/1024/1024+"mb");
          }
      ```
     - 获取jvm可用的处理器核心的数量
     ```java
         /*
          * 获取jvm可用的处理器核心的数量
          * */
         public static void getAvailableProcessors() {
             int value = Runtime.getRuntime().availableProcessors();
             System.out.println(value);
         }
     ``` 
     - 执行系统命令
     ```java
        public static void commend() {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    Process process = runtime.exec("calc");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
     ```
- Runtime类
  - 将要执行的cmd命令用String对象定义，用Runtime.getRuntime().exec()方法执行命令，例如关闭QQ进程的命令：
    - ```java
           String command = "taskkill /f /im qq.exe";
           
           Runtime.getRuntime().exec(command);
      ```
  - 使用Runtime对象
    - ```java
          Runtime run= Runtime.getRuntime();
          
          run.exec("D:\Program Files (x86)\Tencent\QQ\Bin\QQScLauncher.exe");
          
          run.exit(0);
      ```   
  - Java调用控制台命令
  ```java
     String shell = "ping www.baidu.com";//需要执行的命令
     
     BufferedReader br = null;
     try {
     Process p = Runtime.getRuntime().exec(shell);//调用控制台执行shell
     br = new BufferedReader(new InputStreamReader(p.getErrorStream()));//获取执行后出现的错误；getInputStream是获取执行后的结果
     
     String line = null;
     StringBuilder sb = new StringBuilder();
     while ((line = br.readLine()) != null) {
     sb.append(line + "\n");
     System.out.println(sb);
     }
     System.out.println(sb);//打印执行后的结果
     } catch (Exception e) {
     e.printStackTrace();
     }
     finally
     {
     if (br != null)
     {
     try {
     br.close();
     } catch (Exception e) {
     e.printStackTrace();
     }
     }
     }
  ```    