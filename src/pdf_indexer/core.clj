(ns pdf-indexer.core)

(use '[clojure.string :only (split)])
(import org.apache.pdfbox.pdmodel.PDDocument)
(import org.apache.pdfbox.util.PDFTextStripper)
(import org.apache.pdfbox.lucene.LucenePDFDocument)


(defn extract-text [pdf]
  (let [stripper (PDFTextStripper.)])
  (split (.getText (PDFTextStripper.) (. PDDocument load pdf) ) #"\r\n")
  )

(defn extract-document [pdf]
  (let [lucenedoc (LucenePDFDocument.)]
    (let [stripper (PDFTextStripper.)]
      (let [f (clojure.java.io/file pdf)]
      (.setTextStripper lucenedoc stripper)
      (.convertDocument lucenedoc f)
  ))))

(defn -main [filepath]
  (extract-document filepath)
  )