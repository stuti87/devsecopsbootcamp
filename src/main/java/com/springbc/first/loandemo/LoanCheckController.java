package com.springbc.first.loandemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class LoanCheckController {

    @GetMapping("/loancheckbc/{cs}/{loanamount}/{salary}")
    public ResponseEntity<LoanResponse> checkLoanLimit(@PathVariable ("cs") int cs, @PathVariable ("loanamount") int loanamount, @PathVariable ("salary") int salary){
//TODO add logic
        System.out.println("check loan amount :"+loanamount);
        int approvedLoanAmount=0;
        int status=0;
        if (salary>50000 && cs > 700)
        {
            status=1;
            if(loanamount>1000000)
                approvedLoanAmount=1000000;
            else
                approvedLoanAmount=loanamount;
        }
    LoanResponse lr = new LoanResponse(status,approvedLoanAmount);
        return ResponseEntity.ok(lr);

    }

    @GetMapping("/healthcheck")
    public String checkLoanLimit(){
//TODO add logic
System.out.println("I am up");
        return "I am up";
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> getPostTest(@PathVariable ("id") String id){
        String uri = "https://jsonplaceholder.typicode.com/posts/";

        PostResponse pr= RestClient.create().get().uri(uri+id).retrieve().body(PostResponse.class);
System.out.println("post response message"+id);
        return ResponseEntity.ok(pr);
    }


}
