package com.nsinha.graph

import com.nsinha.graph.appConfig.ApplicationConfig
import com.nsinha.graph.factories.GraphFactory
import com.nsinha.graph.interfaces.{GraphOpsTrait, OpaqeClass}
import com.nsinha.graph.utils.dot.DotReaderImpl
import org.scalatest.FunSuite

/**
  * Created by nsinha on 2/4/17.
  */
class TestGraph extends FunSuite{
  ApplicationConfig

  test("1") {
    val _g = GraphFactory.createGraphOfOpaquesInteractive()
    val graphOps = new GraphOpsTrait[OpaqeClass] {
      override val g: G = _g
    }

    graphOps.printGraph
    graphOps.printGraphDot("/tmp/1")

    testDfs(graphOps)
    testBfs(graphOps)
    testDotReader("/tmp/1")

  }


  def testDfs[A](g: GraphOpsTrait[A]) = {
    val tree = g.dfsTree("n0")

    tree.toList.map (x => {
      val gOps = new GraphOpsTrait[A] {
        override val g = x
      }
      gOps.printGraph
      gOps.printGraphDot("/tmp/testDfs")
    })
  }

  def testBfs[A](g: GraphOpsTrait[A]) = {
    val tree = g.bfsTree("n0")

    tree.toList.map (x => {
      val gOps = new GraphOpsTrait[A] {
        override val g = x
      }
      gOps.printGraph
      gOps.printGraphDot("/tmp/testBfs")
    })
  }

  def testDotReader(fileName: String) = {
    val dotReader = new DotReaderImpl[OpaqeClass]
    val _g = dotReader.readFileIntoGraph(fileName)
    val graphOps = new GraphOpsTrait[OpaqeClass] {
      override val g: G = _g
    }

    graphOps.printGraphDot("/tmp/testReadGraph")

  }
}
