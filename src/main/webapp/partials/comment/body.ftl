<#-- @ftlvariable name="comment" type="ru.qatools.school.twister.models.Comment" -->
<#macro commentTemplate comment inPost>
<li class="list-group-item">
    <div class="signature">
        <a href="/user/${comment.userId}" name="comment-${comment.longId}">
            <i class="fa fa-user"></i>
            ${comment.user.login?html}
        </a>

        <b class="divider-slash"></b>

        <span>
            <i class="fa fa-clock-o"></i>
            ${comment.createdAt}
        </span>
    </div>
    <div class="commentBody">
        ${comment.body?html}

        <#if !inPost >
            <a href="/post/${comment.post}#comment-${comment.longId}" >
                <p class="pull-right" style="font-size: .85em;">
                    <i class="fa fa-external-link"></i>
                    Read all discuss to post <em>${comment.postTitle}</em>
                </p>
            </a>
        </#if>
    </div>
</li>
</#macro>
