package zwj.test102_File

import java.io.{PrintWriter, FileInputStream}

/**
 * Created by Administrator on 2016/2/11 0011.
 */
object testFile {

  //read line
  import scala.io.Source
  val source = Source.fromFile("src/zwj/test102_File/myfile.txt") //第二个参数编码方法：,"UTF-8"

  def getEachRow(){
    //get each row
    val lineIterator = source.getLines
    for(l<-lineIterator)println(l)
  }

  def getArray(): Unit ={
    // return an array from all the rows
    val lines = source.getLines.toArray   //将所有行放到数组中
    for(line <- 0.until(lines.length))println(lines(line))
  }

  def getArrayBuffer(): Unit ={
    //return an arrayBuffer from all the rows
    val lines_buf = source.getLines().toBuffer  //将所有行放到数组缓冲中
    println(lines_buf)
  }

  def getWholeString(): Unit ={
    //get the whole string
    val contents = source.mkString(",")   //mkString可以无参数，也可以指定数组元素间隔符
    println("whole string="+contents)
  }

  def getChars(): Unit ={
    //get each char
    //for(c<-source)print(c+" ")  //只能显示第一行的字符
    val iter = source.buffered    //迭代所有字符
    while(iter.hasNext){
      println(iter)
      println(iter.head)
      if(iter.head=='c'){   //查找c字符
        println("get it")
      }
      else println("not get")
      iter.next
    }
  }

  def getWords(): Unit ={
    val tokens = source.mkString.split("\\s+") //得到所有行的word(回车被当做了空格）,得到的是java.lang.String类型
    println(tokens)
    for(token<-tokens)println(token)
    //
    var pairs = for(i<-0 until tokens.length if i%2==0)yield (tokens(i)->tokens(i+1))  //一行2个，拆分出每行，每行的两个word组成map
    println(pairs)
    //
    val numbers = tokens.filter(_.matches("[0-9]+")).map(_.toDouble)  //_代表前面集合中的每个元素
    for(number<-numbers)print(number+" ")
  }

  def test(): Unit ={
    val lineIterator = source.getLines
    val TwoDimData = lineIterator.map(_.split(" "))
    println("array is traveled again:"+TwoDimData.isTraversableAgain) //false
    val twoDimDataBuf = TwoDimData.toBuffer  //这里要添加toBuffer/toArray方法，否则TwoDimData遍历一次后就为空
    //查看
    for(good<-twoDimDataBuf){
      for(g<-good)print(g+" ")
      println
    }
    val goods = twoDimDataBuf.map(line=>(line(0),line(1)))
    println(goods)
  }

  def getBinaryFile(): Unit ={
    //read binary file using java class
    val filename = "src\\zwj\\test102_File\\myfile.txt"
    import java.io.File   //使用java类库
    val file = new File(filename)
    val in = new FileInputStream(file)
    val bytes = new Array[Byte](file.length.toInt)
    in.read(bytes)
    in.close()
  }

  def writeToFile(): Unit ={
    //using java printWriter
    val out = new PrintWriter("src\\zwj\\test102_File\\out.txt")
    out.print("%6d %10.2f".format(123,34.032))
    out.append("saaa")
    for(i<-1 to 100)out.println(i)
    out.close()
  }

  def main(args:Array[String]): Unit ={
    /*下面的函数执行同时只能执行一个,source变为了空:source是一个指针指向文件起始，当遍历文件一遍后指针指向了文件末尾，下次再遍历的时候就读取不到内容*/
    /*getEachRow()
    getArray()
    getArrayBuffer()
    getWholeString()
    getChars()
    getWords()*/
    test
    source.close()

    //getBinaryFile()
    //writeToFile()
  }

}
