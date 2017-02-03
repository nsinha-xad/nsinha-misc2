package com.nsinha.graph.application

import com.nsinha.graph.appConfig.ApplicationConfig
import com.nsinha.graph.factories.GraphFactory
import com.nsinha.graph.interfaces.{Graph, GraphOpsTrait, OpaqeClass}

/**
  * Created by nsinha on 1/28/17.
  */
object TestOpaqueGraph {
  {
    ApplicationConfig
  }

  def main(args: Array[String]): Unit = {
    val _g = GraphFactory.createGraphOfOpaquesInteractive()
    val graphOps = new GraphOpsTrait[OpaqeClass] {
      override val g: G = _g
    }

    graphOps.printGraph
    graphOps.printGraphDot("/tmp/1")

    testDfs(graphOps)
    testBfs(graphOps)

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

}
