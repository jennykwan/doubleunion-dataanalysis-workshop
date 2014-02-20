(defproject doubleunion-dataanalysis-workshop "0.1.0-SNAPSHOT"
  :description "Data Analysis and Visualization with Clojure / Incanter and ClojureScript / D3"
  :url "http://alyssackwan.github.io/doubleunion-dataanalysis-workshop/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]]
  :main ^:skip-aot name.alyssackwan.census.main
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
