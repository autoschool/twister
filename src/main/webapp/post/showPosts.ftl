<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister">
<div class="row">
    <div class="col-md-12">


        <#list model.posts as post>
            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="row">
                        <div class="col-md-10 col-sm-9">
                            <H1><a href="/post/${post.id}">${post.title}</a></H1>

                            <div class="row">
                                <div class="col-xs-9">
                                    <p class="post-body--short"><a href="/post/${post.id}">${post.body}</a></p>
                                    <a href="/post/${post.id}" class="btn btn-default">Read more</a> <br><br>

                                    <div>
                                        <span class="glyphicon glyphicon-time"></span>
                                        <span>${post.createdAt}</span>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</@layout.layout>
