function formSubmit(startAction, thisForm, formAct) {
    console.log(";;"+ startAction +";;" + thisForm +";;" + formAct  );
	if (typeof thisForm == "string") {
        thisForm = document.forms[thisForm];
    }

    if (formAct != undefined) {
        thisForm.elements['formAct'].value = formAct;
    }
        thisForm.action = startAction;
        thisForm.submit();
}