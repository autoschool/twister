<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister.${model.profile.name}" >
<div class="row">
    <div class="col-xs-4">
        <#if model.profile.picture?? >
            <img src="http://c7.ucarecdn.com/${model.profile.picture}/pic.jpg"
                 class="img-rounded img-responsive center-block">
        </#if>
    </div>
    <div class="col-xs-8" id="username">
        <H1>${model.profile.name}</H1> <br>
        With Twister since
    ${model.profile.createdAt}
    </div>


</div>

<div class="row" style="margin-top: 20px">
    <#if model.authUser?? && model.profile == model.authUser>
        <form action="/user/save" method="post">

            <div class="form-group">
                <input type="hidden" role="uploadcare-uploader"
                       data-images-only="true" name="picture"/>


                <button type="submit" class="btn btn-success btn-sm"
                        style="height: 28px; box-sizing: border-box; margin-bottom: 2px;">Save</button>
            </div>
        </form>
    </#if>
</div>


<script>
    UPLOADCARE_LOCALE = "en";
    UPLOADCARE_TABS = "file";
    UPLOADCARE_AUTOSTORE = true;
    UPLOADCARE_PUBLIC_KEY = "6840cb6125ff4ccc690f";
</script>
<script src="//ucarecdn.com/widget/1.5.3/uploadcare/uploadcare.full.min.js"></script>

</@layout.layout>
