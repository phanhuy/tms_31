<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>Struts2 File Upload & Save Example</h2>
<s:actionerror />
<s:form action="../others/userImage" method="post" enctype="multipart/form-data">
    <s:file name="userImage" label="User Image" />
    <s:submit value="Upload" align="center" />
</s:form>


<img src="./home/phanhuy/data/murasaki_shikibu.jpg" />