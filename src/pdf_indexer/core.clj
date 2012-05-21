(ns pdf-indexer.core)

(use '[clojure.string :only (split)])

(import org.apache.pdfbox.pdmodel.PDDocument)
(import org.apache.pdfbox.util.PDFTextStripper)
(import org.apache.pdfbox.lucene.LucenePDFDocument)

(defn compare-docs [doc-one doc-two]
  ;; for entry in metadata:
  ;;  compare lengths of metadata
  ;;   - if any differs, take the longest, log the shortest
  )

(defn normalize-text [text]
  ;; define regex'es for capturing:
  ;; cells containing only numbers
  ;; cells containing only punctuation
  ;; cells containing what looks like headers (recurring author name, timestamps copyright notices, company names etc.
  
  )

(defn extract-text [pdf]
  (split (.getText (PDFTextStripper.) (. PDDocument load pdf) ) #"\r\n")
  )

(defn extract-metadata [pdf]
  (.getMetadata (PDFTextStripper.) (. PDDocument load pdf) )
  )

(defn extract-document [pdf]
  (let [lucenedoc (LucenePDFDocument.)]
    (let [stripper (PDFTextStripper.)]
      (let [f (clojure.java.io/file pdf)]
        (.setTextStripper lucenedoc stripper)
        (.convertDocument lucenedoc f)
        ))))

(defn inspect-lucene-doc
  "inspect a lucene document by field"
  [lucene-doc]
  (let [fields (.getFields lucene-doc)]
    (doseq [field fields]
      (println (.name field) (.stringValue field))
      )))

(defn -main [filepath]
  ;;(inspect-lucene-doc (extract-document filepath))
  (extract-metadata filepath)
  )