
import scala.collection.mutable
import scala.util.Random

object TreeNewBee {

  val ns: Array[String] =
    """
      |{n4}是{n1}{n4}，{n1}行业{n3}。{n4}是{n1}{n2}{n4}，通过{n3}和{n3}达到{n3}。{n4}是在{n4}采用{n2}打法达成{n4}。{n4}{n4}作为{n2}为产品赋能，{n4}作为{n2}的评判标准。亮点是{n2}，优势是{n2}。{n1}整个{n4}，{n1}{n2}{n1}{n4}。{n3}是{n3}达到{n3}标准。
      |皮实、复盘、赋能、加持、沉淀、倒逼、落地、串联、协同、反哺、兼容、包装、重组、履约、响应、量化、发力、布局、联动、细分、梳理、输出、加速、共建、共创、支撑、融合、解耦、聚合、集成、对标、对齐、聚焦、抓手、拆解、拉通、抽象、摸索、提炼、打通、吃透、迁移、分发、分层、封装、辐射、围绕、复用、渗透、扩展、开拓、给到、死磕、破圈
      |漏斗、中台、闭环、打法、纽带、矩阵、刺激、规模、场景、维度、格局、形态、生态、话术、体系、认知、玩法、体感、感知、调性、心智、战役、合力、赛道、基因、因子、模型、载体、横向、通道、补位、链路、试点
      |新生态、感知度、颗粒度、方法论、组合拳、引爆点、点线面、精细化、差异化、平台化、结构化、影响力、耦合性、易用性、便捷性、一致性、端到端、短平快、护城河
      |底层逻辑、顶层设计、交付价值、生命周期、价值转化、强化认知、资源倾斜、完善逻辑、抽离透传、复用打法、商业模式、快速响应、定性定量、关键路径、去中心化、结果导向、垂直领域、归因分析、体验度量、信息屏障""".stripMargin.split("\n")

  val rand = new Random(System.currentTimeMillis())

  val nss: Array[mutable.Stack[String]] = new Array[mutable.Stack[String]](4)

  val stencil: String = ns(1)

  def main(args: Array[String]): Unit = {
    
    for (i <- 2 to 5) {
      nss(i - 2) = mutable.Stack(rand.shuffle(ns(i).split("、").toSeq): _*)
    }

    println("\\{n(\\d)}".r.replaceAllIn(stencil, { m => nss(m.group(1).toInt - 1).pop() }))
  }
}
