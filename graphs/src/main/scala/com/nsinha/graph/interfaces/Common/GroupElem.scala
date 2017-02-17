package com.nsinha.graph.interfaces.Common

/** Created by nsinha on 2/13/17.
  */

trait GroupElem[A] extends Ordered[A] {
  def `+`(that : A) : A
  def `0` : A
}

trait RingElem[A] extends GroupElem[A] {
  def `*`(that : A) : A
  def `1` : A
}

//hard to imagine any shortest path concept in this group
case class UnAssociativeGroupElem(name : String) extends Ordered[UnAssociativeGroupElem] with GroupElem[UnAssociativeGroupElem] {
  override def compare(that : UnAssociativeGroupElem) : Int = name.compare(that.name)
  override def `+`(that : UnAssociativeGroupElem) = UnAssociativeGroupElem((this.name.toDouble - that.name.toDouble).toString)
  override def `0` = UnAssociativeGroupElem("0")
}
//hard to imagine any shortest path concept in this group
case class UnAssociativeNonDistributiveRingElem(name : String) extends Ordered[UnAssociativeNonDistributiveRingElem] with RingElem[UnAssociativeNonDistributiveRingElem] {
  override def compare(that : UnAssociativeNonDistributiveRingElem) : Int = name.compare(that.name)
  override def `+`(that : UnAssociativeNonDistributiveRingElem) = UnAssociativeNonDistributiveRingElem((this.name.toDouble - that.name.toDouble).toString)
  override def `0` = UnAssociativeNonDistributiveRingElem("0")
  override def `*`(that : UnAssociativeNonDistributiveRingElem) = UnAssociativeNonDistributiveRingElem((this.name.toDouble / that.name.toDouble).toString)
  override def `1` = UnAssociativeNonDistributiveRingElem("1")
}

/*
Shortest path is well defined for associative groups.


 */
case class AssociativeGroupElem(name : String) extends Ordered[AssociativeGroupElem] with GroupElem[AssociativeGroupElem] {
  override def compare(that : AssociativeGroupElem) : Int = name.compare(that.name)
  override def `+`(that : AssociativeGroupElem) = AssociativeGroupElem((this.name.toDouble + that.name.toDouble).toString)
  override def `0` = AssociativeGroupElem("0")
}

case class AssociativeNonDistributiveRingElem(name : String) extends RingElem[AssociativeNonDistributiveRingElem] {
  override def compare(that : AssociativeNonDistributiveRingElem) : Int = name.compare(that.name)
  override def `+`(that : AssociativeNonDistributiveRingElem) = AssociativeNonDistributiveRingElem((this.name.toDouble + that.name.toDouble).toString)
  override def `0` = AssociativeNonDistributiveRingElem("0")
  override def `*`(that : AssociativeNonDistributiveRingElem) = AssociativeNonDistributiveRingElem((this.name.toDouble / that.name.toDouble).toString)
  override def `1` = AssociativeNonDistributiveRingElem("1")
}

//the best field as far as optimization of algorithms matter.
case class AssociativeDistributiveRingElem(name : String) extends RingElem[AssociativeDistributiveRingElem] {
  override def compare(that : AssociativeDistributiveRingElem) : Int = name.compare(that.name)
  override def `+`(that : AssociativeDistributiveRingElem) = AssociativeDistributiveRingElem((this.name.toDouble + that.name.toDouble).toString)
  override def `0` = AssociativeDistributiveRingElem("0")
  override def `*`(that : AssociativeDistributiveRingElem) = AssociativeDistributiveRingElem((this.name.toDouble * that.name.toDouble).toString)
  override def `1` = AssociativeDistributiveRingElem("1")
}

