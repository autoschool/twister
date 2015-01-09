<#-- @ftlvariable name="model" type="ru.qatools.school.twister.view.ViewData" -->
<#import "../layouts/main.ftl" as layout />
<@layout.layout title="Twister.${model.profile.name}" >

<div class="row">
    <div class="col-xs-3">
        Name
    </div>
    <div class="col-xs-9" id="username">
    ${model.profile.name}
    </div>
</div>
<div class="row">
    <div class="col-xs-3">
        With Twister since
    </div>
    <div class="col-xs-9">
    ${model.profile.createdAt}
    </div>
</div>

<div class="row" style="margin-top: 20px">
    <form>

        <div class="form-group">
            <input type="hidden" role="uploadcare-uploader"
                   data-images-only="true"/>
        </div>

        <button type="submit" class="btn btn-default">Save</button>
    </form>


</div>

<script>
    UPLOADCARE_LOCALE = "en";
    UPLOADCARE_TABS = "file";
    UPLOADCARE_AUTOSTORE = true;
    UPLOADCARE_PUBLIC_KEY = "6840cb6125ff4ccc690f";
</script>
<script src="//ucarecdn.com/widget/1.5.3/uploadcare/uploadcare.full.min.js"></script>

</@layout.layout>
