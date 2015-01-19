<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister">
<div class="row">
    <div class="col-md-12">


        <#list model.posts as post>
            <div class="panel panel-default">
                <div class="panel-body">
                    <h1>
                        <a href="/post/${post.id}">${post.title}</a>
                    </h1>

                    <div class="signature">
                        <a href="/user/${post.userId}">
                            <i class="glyphicon glyphicon-user"></i>
                            ${post.user.name}
                        </a>

                        <b class="divider-slash"></b>

                        <span>
                            <i class="glyphicon glyphicon-time"></i>
                            ${post.createdAt}
                        </span>

                        <#if model.authUser?? && post.user == model.authUser>
                            <span>
                                <b class="divider-slash"></b>

                                <form role="form" action="/post/${post.id}/edit" method="get" style="display: inline-block;">
                                    <a href="#" onclick="this.parentNode.submit()">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                        edit
                                    </a>
                                </form>

                                <b class="divider-slash"></b>

                                <form role="form" action="/post/${post.id}/remove" method="post" style="display: inline-block;">
                                    <a href="#" onclick="this.parentNode.submit()">
                                        <span class="glyphicon glyphicon-remove"></span>
                                        remove
                                    </a>
                                </form>
                            </span>
                        </#if>
                    </div>

                    <div class="post-body--short">
                        <a href="/post/${post.id}">${post.body}</a>
                    </div>

                    <a href="/post/${post.id}" class="btn btn-default">Read more</a>
                </div>
            </div>
        </#list>
    </div>
</div>
</@layout.layout>
