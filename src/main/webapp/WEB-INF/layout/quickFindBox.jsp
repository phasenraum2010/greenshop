<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">Quick Find</div>
    <div class="ui-widget-content infoBoxContents" style="text-align: center;">
        <form name="quick_find" action="<c:url value="/search"/>" method="get">
            <input type="text" name="keywords" size="10" maxlength="30" style="width: 75%" />&nbsp;
            <input type="hidden" name="search_in_description" value="1" />
            <input type="image" src="includes/languages/english/images/buttons/button_quick_find.gif"
                   alt="Quick Find" title=" Quick Find " />
            <br />Use keywords to find the product you are looking for.
            <br />
            <a href="<c:url value="/advancedSearch"/>"><strong>Advanced Search</strong></a>
        </form>
    </div>
</div>
