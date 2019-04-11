Query.noConflict()

jQuery.imageMagnify={
	dsettings: {
const domain = "meet.jit.si";
const meetingName = "anythinghere";
const parentElement = document.getElementById('api-parent');
console.warn('parentElement', parentElement);
var options = {
    roomName: meetingName,
    width: 700,
    height: 180,
    parentNode: parentElement,
    interfaceConfigOverwrite: {
        filmStripOnly: true
    }
}
var api = new JitsiMeetExternalAPI(domain, options);
var iframe = api.getIFrame();
api.executeCommand('toggleShareScreen')