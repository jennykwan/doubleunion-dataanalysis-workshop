(ns name.alyssackwan.census.data
  (:require [clojure.java.io :as io]
            [incanter.excel :as inc-excel]))

(def income-and-poverty-01-xls
  (second (second (inc-excel/read-xls (str (io/resource "data/IPE01.xls"))))))

(def income-and-poverty-01-years
  (range 1995 2010))

(def income-and-poverty-01
  (let [years income-and-poverty-01-years
        counties (map (fn [row]
                        (get row "STCOU"))
                      income-and-poverty-01-xls)]
    (zipmap years
            (map (fn [year]
                   (zipmap counties
                           (map (fn [row]
                                  (get row (str "IPE010" (quot year 1000) (rem year 100) "D")))
                                income-and-poverty-01-xls)))
                 years))))
