(ns pdf-indexer.core
  (:use '[clojure.string :only (lower-case)])
  (:import (org.apache.lucene.document Document Field Field$Store Field$Index NumericField)
           (org.apache.lucene.analysis.standard StandardAnalyzer)
           (org.apache.lucene.store FSDirectory)
           (org.apache.lucene.search IndexSearcher QueryWrapperFilter TermQuery Sort)
           (org.apache.lucene.queryParser QueryParser)
           (org.apache.lucene.index IndexWriter IndexWriter$MaxFieldLength IndexReader Term)
           (org.apache.lucene.util Version)
           (java.io File)))

(defn create-analyzer []
  (StandardAnalyzer. (. Version LUCENE_30))
  )

(defn create-directory [path]
  (FSDirectory. (File. path))
  )

;(defn create-index-reader) should be on an ad-hoc basis

(defn index-document [doc])

(defn search [query])

