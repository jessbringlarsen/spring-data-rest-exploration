package dk.bringlarsen.bportal.api.controller;

import dk.bringlarsen.bportal.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@BasePathAwareController
@RequestMapping(value = "/")
public class ImportController {

    private ImportService importService;

    @Autowired
    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @ResponseBody
    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public ResponseEntity<?> doImport() throws IOException {
        importService.doImport();
        return new ResponseEntity(HttpStatus.OK);
    }
}
