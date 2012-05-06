(defproject pdf-indexer "1.0.0-SNAPSHOT"
  :description "command line program that indexes a PDF file to a global index"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.apache.pdfbox/pdfbox "1.6.0"]]
  :dev-dependencies [[lein-eclipse "1.0.0"]]
  :main pdf-indexer.core
  )