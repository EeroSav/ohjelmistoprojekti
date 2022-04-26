package com.example.ohjelmistoprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ohjelmistoprojekti.model.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private AnswerRepository arepository;

    @Autowired
    private QuestionRepository qrepository;

    @GetMapping("/{questionid}")
        public Question getQuestion(@PathVariable Long questionid){
            return qrepository.findById(questionid).orElseThrow(RuntimeException::new);
        }

    @GetMapping("/{answerid}")
        public Answer getAnswer(@PathVariable Long answerid){
        return arepository.findById(answerid).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/questions")
    public ResponseEntity createQuestion(@ModelAttribute Question question) throws URISyntaxException{
        Question savedQuestion = qrepository.save(question);
        return ResponseEntity.created(new URI("/questions/" + savedQuestion.getQuestionid())).body(savedQuestion);
    }


    @PostMapping("/questions")
    public ResponseEntity createAnswer(@ModelAttribute Answer answer) throws URISyntaxException{
        Answer savedAnswer = arepository.save(answer);
        return ResponseEntity.created(new URI("/answers/" + savedAnswer.getAnswerid())).body(savedAnswer);
    }

    @PutMapping("/{answerid}")
    public ResponseEntity updateClient(@PathVariable Long answerid, @RequestBody Answer answer)
    {
        Answer currentAnswer =
                arepository.findById(answerid).orElseThrow(RuntimeException::new);
                currentAnswer.setInput(answer.getInput());
                currentAnswer = arepository.save(answer);

                return ResponseEntity.ok(currentAnswer);
    }

    @DeleteMapping("/{answerid}")
    public ResponseEntity updateAnswer(@PathVariable Long answerid, @RequestBody Answer answer)
    {
        arepository.deleteById(answerid);
        return ResponseEntity.ok().build();
    }
}

/*    @RequestMapping("/questions")
    public questions(@RequestParam) {
        Answer answer = new Answer();
        model.addAttribute("answer", new Answer());
        model.addAttribute("questions", qrepository.findAll());
        return "questions";
    }

    @RequestMapping(value = "/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "addquestion";
    }

    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String saveQuestion(Question question) {
        qrepository.save(question);
        return "redirect:/questions";
    }

        //REST haku kaikille kysymyksille
    @RequestMapping(value="/allQuestions")
    public @ResponseBody List<Question> questionListRest() {
        return (List<Question>) qrepository.findAll();
    }

        //REST haku kaikille vastauksille
    @RequestMapping(value="/allAnswers")
    public @ResponseBody List<Answer> answerListRest(){
        return (List<Answer>) arepository.findAll();
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveAnswer(Answer answer){
        arepository.save(answer);
        return "redirect:questions";
    }
}
*/