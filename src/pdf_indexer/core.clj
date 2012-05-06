(ns pdf-indexer.core)

(use 'clojure.string)
(import org.apache.pdfbox.pdmodel.PDDocument)
(import org.apache.pdfbox.util.PDFTextStripper)

(defn extract-text [pdf]
  (let [stripper (PDFTextStripper.)])
  (split (.getText (PDFTextStripper.) (. PDDocument load pdf) ) #"\r\n")
  )  
  

(defn -main [filepath]
  (extract-text filepath)
  )