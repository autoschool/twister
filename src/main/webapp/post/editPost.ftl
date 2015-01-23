<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Edit post - Twister">
<div class="row">
    <div class="col-md-12">
        <form class="form" role="form" action="/post/edit" method="post">
            <input type="hidden" value="${model.post.id}" name="id">
            <div class="page-header">
                <div class="form-group">
                    <input type="text" class="form-control" id="title" name="title"
                           placeholder="Post Title" value="${model.post.title}">
                </div>
            </div>
            <div class="form-group">
                <textarea class="form-control" rows="10" name="body">${model.post.body}</textarea>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-danger pull-right" id="publish">Update</button>
                </div>
            </div>
        </form>
    </div>
</div>
</@layout.layout>