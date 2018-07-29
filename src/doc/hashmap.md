<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
<style>
*{
    font-size: 16px;
    font-family: 幼圆;
}
body{
    background-color: #FDF6E3；
    line-height: 1.5em; 
    max-width: 960px;
    margin: 0 auto;
}
/* !important的作用是提高指定样式规则的应用优先权。*/
body>*:first-child {
    margin-top: 0 !important;
}

body>*:last-child {
    margin-bottom: 0 !important;
}
/* <tt> 标签与 <code> 和 <kbd> 标签一样，<tt> 标签和必
需的 </tt> 结束标签告诉浏览器，要把其中包含的文本显示
为等宽字体。*/

/* 标题 h1~h2*/
/* ====================================================*/
h1 {
  font-size: 2.8em;
  color: #d33682;
  margin: 0.75em;
}
h2 {
  font-size: 2.4em;
  color: #9B31EA;
  margin: 0.75em;

}
h3 {
  font-size: 1.8em;
  color: #338000;
  margin: 0.75em;
}
h4 {
  font-size: 1.4em;
  margin: 0.75em;
}

/* p,a,,hr,list,table*/

/* ==================================================*/
/*<blockquote> 标签定义摘自另一个源的块引用。浏览器
通常会对 <blockquote> 元素进行缩进。
*/
blockquote {
    font-style: italic;
    border-left: 5px solid;
    margin-left: 2em;
    padding-left: 1em;
}

/* p*/
p {
    margin-bottom: 1.5em;
}
/* hr */
hr {
    clear: both;
    margin: 15px 0;
    height: 0px;
    overflow: hidden;
    border: none;
    background: transparent;
    border-bottom: 4px solid #ddd;
    padding: 0;
}
/*  link*/

a {
    color: #b58900;
    text-decoration: none;
}
a:focus {
    outline: thin dotted;
}
a:active,a:hover {
    outline: 0;
}
a:hover {
    color: #cb4b16;
    text-decoration: underline;
}
a:visited {
    color: #cb4b16;
}

/* list */

ul,
ol {
    margin: 0 0 1.5em 1.5em;
}
ol li {
    list-style-type: decimal;
    list-style-position: outside;
}
ul li {
    list-style-type: disc;
    list-style-position: outside;
}

/* tables */

table thead, table tr {
border-top-width: 1px;
border-top-style: solid;
border-top-color: rgb(235, 242, 224);
}
table {
border-bottom-width: 1px;
border-bottom-style: solid;
border-bottom-color: rgb(235, 242, 224);
}
thead,table td:nth-child(1){
    font-weight:bold;
    color: #7034ca;
}
/* Padding and font style */
table td, table th {
padding: 5px 10px;
font-size: 12px;
font-family: Verdana;
color: rgb(149, 170, 109);
}

/* Alternating background colors */
table tr:nth-child(even) {
background: rgb(230, 238, 214)
}
table tr:nth-child(odd) {
background: #FFF
}

/* code */
/* =======================================*/
pre{
    border-radius: .5em;
    border: .3em solid hsl(0, 0%, 33%);
    box-shadow: 1px 1px 0.5em black inset;
    margin: .5em 0;
    overflow: auto;
    padding: 1em;
    background: hsl(0, 0%, 8%);
}

pre, code, tt {
    font-size: 12px;
    font-family: Consolas, "Liberation Mono", Courier, monospace;
}

code, tt {
    margin: 0 0px;
    padding: 0px 0px;
    white-space: nowrap;
    border: 1px solid #eaeaea;
    background-color: #f8f8f8;
    border-radius: 3px;
}

pre>code {
    margin: 0;
    padding: 0;
    white-space: pre;
    color: rgba(203, 75, 22, 0.86);
    font-size: 16px;
    border: none;
    background: transparent;
 
}



pre code, pre tt {
    background-color: transparent;
    border: none;
}

/*目录形成的范围*/
#outline-list {
    height: 325px;
    position: fixed;
    overflow-y:scroll;
    overflow-x:hidden;
    bottom: 80px;
    right: 15px;
    width: 220px;
}
/* 设置滚动条的样式 */
::-webkit-scrollbar {
width:12px;
}
/* 滚动槽 */
::-webkit-scrollbar-track {
-webkit-box-shadow:inset006pxrgba(0,0,0,0.3);
border-radius:10px;
}
/* 滚动条滑块 */
::-webkit-scrollbar-thumb {
border-radius:10px;
background:rgba(0,0,0,0.1);
-webkit-box-shadow:inset006pxrgba(0,0,0,0.5);
}
::-webkit-scrollbar-thumb:window-inactive {
background:rgba(255,0,0,0.4);
}
</style>
# HashMap

## HashMap简介



- HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。
- HashMap 继承于AbstractMap，实现了Map、Cloneable、java.io.Serializable接口。
- HashMap 的实现不是同步的，这意味着它不是线程安全的。它的key、value都可以为null。
- HashMap 中的映射不是有序的。

 >HashMap的实例有两个参数影响其性能：“初始容量” 和 “加载因子”。容量是哈希表中桶的数量，初始容量 
只是哈希表在创建时的容量。加载因子 是哈希表在其容量自动增加之前可以达到多满的一种尺度。
当哈希表中的条目数超出了加载因子与当前容量的乘积时，则要对该哈希表进行 rehash 操作（即重建内部数据结构），
从而哈希表将具有大约两倍的桶数。通常，默认加载因子是 0.75, 这是在时间和空间成本上寻求一种折衷。
加载因子过高虽然减少了空间开销，但同时也增加了查询成本（在大多数 HashMap 类的操作中，包括 get 和 put 操作，都反映了这一点）。
在设置初始容量时应该考虑到映射中所需的条目数及其加载因子，以便最大限度地减少 rehash 操作次数。
如果初始容量大于最大条目数除以加载因子，则不会发生 rehash 操作。

- 在JDK1.8之前,HashMap底层是基于哈希表的,数据结构是数组+链表 
- 在JDK1.8,引入了红黑树,数据结构是数组+链表+红黑树
 
  ![hashmap](./img/hashmap2.jpg)
  - 引入原因：
    - 解决解决发生哈希碰撞后,链表过长从而导致索引效率慢的问题
    - 具体：
      - 利用红黑树快速增删改查的特点
      - 时间复杂度从O(n) 降为 O(logn)
   
   
  - 应用场景
    - 当链表长度>8时,将该链表转换成红黑树
    - 即红黑树作为存储数据&解决Hash冲突的第3方案 
   
      - 无冲突时:存放数组
      - 冲突&链表长度<8时:存放在单链表
      - 冲突&链表长度>8时:存放在红黑树
## HashMap构造函数
- HashMap共有4个构造函数
~~~
// 默认构造函数。
HashMap()

// 指定“容量大小”的构造函数
HashMap(int capacity)

// 指定“容量大小”和“加载因子”的构造函数
HashMap(int capacity, float loadFactor)

// 包含“子Map”的构造函数
HashMap(Map<? extends K, ? extends V> map)
~~~

- HashMap的API
~~~
void                 clear()
Object               clone()
boolean              containsKey(Object key)
boolean              containsValue(Object value)
Set<Entry<K, V>>     entrySet()
V                    get(Object key)
boolean              isEmpty()
Set<K>               keySet()
V                    put(K key, V value)
void                 putAll(Map<? extends K, ? extends V> map)
V                    remove(Object key)
int                  size()
Collection<V>        values()
~~~
