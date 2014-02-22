(defproject doubleunion-dataanalysis-workshop "0.1.0-SNAPSHOT"
  :description "Data Analysis and Visualization with Clojure / Incanter and ClojureScript / D3"
  :url "http://alyssackwan.github.io/doubleunion-dataanalysis-workshop/"
  :license {:name "GNU General Public License v3"
            :url "http://www.gnu.org/copyleft/gpl.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.5"]
                 [compojure "1.1.6"]
                 [ring "1.2.1"]]
  :main ^:skip-aot name.alyssackwan.census.main
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[midje "1.5.1"]
                                  [ring-mock "0.1.5"]]
                   :plugins [[lein-midje "3.1.1"]]}})
