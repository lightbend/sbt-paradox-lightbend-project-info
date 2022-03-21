/*
 * Copyright 2018 Lightbend Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lightbend.paradox.lightbend

import com.lightbend.paradox.projectinfo._
import sbt._

object LightbendParadoxInfoPlugin extends AutoPlugin {
  private def glossary(anchor: String, label: String): String =
    s"""<a href="https://developer.lightbend.com/docs/introduction/getting-help/support-terminology.html#$anchor" target="_blank" rel="noopener">$label</a>""".stripMargin

  case object Supported extends ReadinessLevel {
    val name =
      s"""${glossary(
          "supported",
          "Supported"
        )}, <a href="https://www.lightbend.com/lightbend-subscription" target="_blank" rel="noopener">Lightbend Subscription</a> provides support"""
  }
  case object Certified extends ReadinessLevel {
    val name =
      s"""${glossary("certified", "Certified")} by <a href="https://www.lightbend.com/" target="_blank">Lightbend</a>"""
  }
  case object Incubating extends ReadinessLevel {
    val name = glossary("incubating", "Incubating")
  }
  case object CommunityDriven extends ReadinessLevel {
    val name = glossary("community-driven", "Community-driven")
  }
  case object EndOfLife extends ReadinessLevel {
    val name =
      s"${glossary("eol", "End-of-Life")}, it is not recommended to use this project any more."
  }

  import ParadoxProjectInfoPlugin.autoImport._

  override def requires = ParadoxProjectInfoPlugin

  override def trigger = allRequirements

  override def projectSettings: Seq[Setting[_]] = lightbendProjectInfoSettings(Compile)

  def lightbendProjectInfoGlobalSettings: Seq[Setting[_]] = Seq(
    readinessLevels ++= Map(
      "Supported" -> Supported,
      "Certified" -> Certified,
      "Incubating" -> Incubating,
      "CommunityDriven" -> CommunityDriven,
      "EndOfLife" -> EndOfLife
    )
  )

  def lightbendProjectInfoSettings(config: Configuration): Seq[Setting[_]] =
    lightbendProjectInfoGlobalSettings ++ inConfig(config)(
      Seq(
        // scoped settings here
      )
    )
}
