<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../../layouts/main.ftl" as layout />
<#import "../post/list.ftl" as postList />
<#import "../comment/list.ftl" as commentList />
<@layout.layout title="Twister.${model.profile.login?html}" >
<div class="row">
    <div class="col-xs-12 col-md-8">
        <div class="panel panel-default user-info">
            <#if model.authUser?? && model.profile == model.authUser>
                <form action="/user/save" method="post">
            </#if>
                    <div class="panel-body">
                        <div class="col-xs-4">
                            <#if model.profile.picture?? >
                                <img src="http://c7.ucarecdn.com/${model.profile.picture}/pic.jpg"
                                     class="user-avatar img-rounded img-responsive center-block">
                            <#else>
                                <img src="/public/app/img/twister.png" width="180" height="180"
                                     class="user-avatar img-rounded img-responsive center-block">
                            </#if>
                        </div>
                        <div class="col-xs-8" >
                            <div class="col-sm-10">
                                <h2 class="details-view">${model.profile.name?html}</h2>
                                <div class="styled-input wide edit-view hidden">
                                    <input type="text"
                                           class="form-control"
                                           name="user-profile-name"
                                           id="user-profile-name"
                                           value="${model.profile.name}" required >
                                    <label>Name</label>
                                    <span></span>
                                </div>

                                <div class="styled-input wide edit-view hidden">
                                    <input type="password"
                                           class="form-control"
                                           name="user-profile-password"
                                           id="user-profile-password"
                                           value="${model.profile.passHash}" >
                                    <label>Password</label>
                                    <span></span>
                                </div>
                            </div>
                        </div>
                    </div>

            <#if model.authUser?? && model.profile == model.authUser>
                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-xs-6" >
                                <div class="uploader edit-view hidden">
                                    <input  type="hidden" role="uploadcare-uploader"
                                            data-images-only="true" name="user-profile-avatar"/>
                                </div>
                            </div>

                            <div class="col-xs-6 text-right" >
                                <button type="button" class="btn btn-success btn-sm details-view"
                                        onclick="turnToEdit()">Edit</button>

                                    <div class="btn-group edit-view hidden" >
                                        <button type="submit" class="btn btn-success btn-sm"
                                                onsubmit="turnToDetails()">Save</button>

                                        <button type="button" class="btn btn-default btn-sm"
                                                onclick="turnToDetails()">Cancel</button>
                                    </div>
                            </div>
                        </div>

                    </div>
                </form>
            </#if>
        </div>
    </div>

    <div class="col-xs-12 col-sm-12 col-md-4">
        <div class="panel panel-primary">
            <div class="panel-heading ">
                <h3 class="panel-title">
                    Info
                </h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-5 text-right">Login</label>
                        <div class="col-sm-7">
                            ${model.profile.login?html}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-5 text-right">With Twister since</label>
                        <div class="col-sm-7">
                            ${model.profile.createdAt}
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-12 col-sm-6">
        <div class="user-profile-collapse-button">
            <a data-toggle="collapse"
               onclick="if ( $('#user-comments').hasClass('in') ) {$('#user-comments').collapse('hide')}"
               class="btn btn-success col-xs-12 ${(model.posts?size <= 0)?string('disabled','')}"
               href="#user-posts" aria-expanded="false" aria-controls="user-posts">
                    <h4>Posts (${model.posts?size})</h4>
            </a>
        </div>
    </div>

    <div class="col-xs-12 col-sm-6">
        <div class="user-profile-collapse-button">
            <a data-toggle="collapse"
               onclick="if ( $('#user-posts').hasClass('in') ) {$('#user-posts').collapse('hide')}"
               class="btn btn-warning col-xs-12 ${(model.comments?size <= 0)?string('disabled','')}"
               href="#user-comments" aria-expanded="false" aria-controls="user-comments" >
                    <h4>Comments (${model.comments?size })</h4>
            </a>
        </div>
    </div>

<div class="col-xs-12">
    <div class="collapse well-sm bg-success user" id="user-posts">
        <@postList.postListTemplate />
    </div>
    <div class="collapse well-sm bg-warning" id="user-comments">
        <@commentList.commentListTemplate comments=model.comments inPost=false />
    </div>
</div>

<script>
    UPLOADCARE_LOCALE = "en";
    UPLOADCARE_TABS = "file";
    UPLOADCARE_AUTOSTORE = true;
    UPLOADCARE_PUBLIC_KEY = "6840cb6125ff4ccc690f";
</script>
<script src="//ucarecdn.com/widget/1.5.3/uploadcare/uploadcare.full.min.js"></script>

<script>
    setTimeout( function() {
        $(".uploadcare-widget-button").addClass("btn btn-primary btn-sm");
    }, 500);

    function turnToEdit() {
        $(".edit-view").removeClass( "hidden");
        $(".details-view").addClass( "hidden");
    }

    function turnToDetails() {
        $(".edit-view").addClass( "hidden");
        $(".details-view").removeClass( "hidden");
    }
</script>

</@layout.layout>
