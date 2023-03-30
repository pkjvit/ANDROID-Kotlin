package com.pkj.wow.androidkotlin.design_patterns.decorator

open class NewsDetail(val titile: String, val description: String){
    override fun toString(): String {
        return "NewsDetail(titile='$titile', description='$description')"
    }
}


class NewsDetailWithDate(val newsDetail: NewsDetail, val date:String)
    : NewsDetail(newsDetail.titile +" - $date", newsDetail.description)

class NewsDetailWithSource(val newsDetail: NewsDetail, val source: String)
    : NewsDetail(newsDetail.titile, newsDetail.description + " - $source")


fun main(){
    val newsDetail = NewsDetail("News title", "News Description")
    println(newsDetail)
    println(NewsDetailWithDate(newsDetail, "Thursday 30th March"))
    println(NewsDetailWithSource(newsDetail, "Source"))
}