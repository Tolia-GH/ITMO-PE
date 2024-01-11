# Essay 1

Good afternoon. 

I'm really excited to be talking to so many programmers of automatic computing machines. 

As you know, computing is becoming more and more important in our society. There's now literally thousands of computers around the world. 

And they're being used from everything from business and accounting to scientific experiments and who knows what they're going to be used for. So more and more computers and coming down in price, coming down in size, computer used to be the size of the entire hall, and now they've shrunk to really tiny proportions. 

So it's this time of really rapid change in the field of computing. So I thought it would be interesting to kind of look ahead a little bit to the future of programming and think about, 

given what we know now, what programming might be like, say, forty years from now. So what I'm going to talk about today, there's been some really interesting research that's been done just in the last ten years or so, and I think it's going to have a lot of implications for what programming might be like in the future. 

So there's four big ideas, kind of four big topics that I want to talk about that have come out of of recent research. But before I get to those four big ideas, I want to talk about the nature of adopting ideas in the first place. So basically what we notice is that technology changes quickly. People's minds change slowly. So it's easy to adopt new technologies. It can be hard to adopt new ways of thinking. 

So, technology wise. 

Gordon Moore he has this company called Intel and. 

He observed about ten years ago that computing capacity was increasing exponentially over time, and he kind of extrapolated this out to about now, and he's been right on target and who knows how long he'll keep it going. But it seems pretty reasonable. So the lesson to be drawn from this is that we can kind of take this for granted. We just kind of wait. Our computers get faster, they get more capable. 

We can just wait and that's just going to happen. What won't just happen if we wait is. People changing, people adopting new ideas. So as an example of that, I'm sure you all remember this guy. 

The old IBM six fifty the, you know, IBM's first kind of general purpose mass produced computer. A lot of us cut our teeth programming on this guy and. 

And in the beginning, we all programmed in absolute binary. When we coded, it was literally writing numeric codes for each instruction. And that was what we did. That was programming. And then after some years of that, stan poley came along and he invented this thing that he called an assembler. So that was the symbolic optimizing assembly program. This language where you could write in words. If you wanted the computer to add something, 

you'd write the word ad. You could use symbolic variable names instead of hard coding. Memory addresses is this much more powerful way of thinking about programming. 

You much more productive. I mean much fewer errors. 

Assembly was shown to these guys, the guys coding a binary, and they just weren't interested at all. They just didn't get it. They didn't see any value in in doing this stuff. So there can be a lot of resistance to new ways of working that require you to kind of unlearn what you've already learned and think in new ways. And there can even be, like, outright hostility. So Johnny von neumann, the great scientist who invented the von neumann computer architecture that we use, 

and so many other things he said, I don't see why anybody would need anything other than machine code. And he one time. So he had a bunch of students and students were all kind of coding along in in binary. And one time one of his students took a little time out to write his own little assembler so he could write an assembly. And von neumann was furious at him, furious that he would waste precious machine time doing the assembly. 

That was clerical work that was supposed to be for people, right ?, And so we saw the same story happen just a little bit later when John bacus and friends came up with this idea that they called fortran, this so called high level language where you could write out your formulas as if you're writing mathematical notation. You could write out loops. And this was shown to the assembly of programmers. 

And once again, they weren't interested. They didn't see any value in that, they just didn't get it. 

I want you to keep this in mind as I talk about the four big ideas that I'm going to talk about today. That it's easy to think that technology, technology is always getting better because of Moore's law, because the computer always getting more capable. But ideas that require people to unlearn what they've learned and think in new ways, there's often enormous amount of resistance. 

People over here, they think they know what they're doing. They think they know what programming is. This programming that's not programming. And so there's going to be a lot of resistance to adopting new ideas. 

The four ideas I want to talk about today. This is all coming out of very recent research. The first one is today we write our programs in code. We write a list of instructions for the computer to do. It's been some really interesting research on direct manipulation of data where you directly manipulate the data structures, and that implicitly builds up a program for the computer to follow. Second thing I want to talk about today, 

we write procedures. Basically, here's a procedure for the computer to do interesting research on programming, using goals, telling the computer what you want, not how to do it. And the computer itself kind of figures out how to do it. Number three, today we program using lines of text in text files. 

People are doing something really remarkable, just like in the last five or ten years. They're hooking video displays up to computers. When you do that, everything changes and we can start thinking about spatial representations of information. And the fourth thing is we program in a sequential programming model. Basically, here's a bunch of instructions. The computer does them one after the other, 

but hardware changing. So we're going to see massively parallel hardware and we're going to need a sound parallel programming model to program on that hardware. 

So. 

The first thing I'm going to talk about is that direct manipulation of data. And I'm going to show this project that Ivan seland did this, this PhD thesis about ten years ago. The system called sketchpad and sketchpad was a system that allowed you to draw pictures on a video display. So he took his light pen and put it on the screen. And so he draw that line, draw that line, have draw some more lines, 

do this little top. He's, he's trying to draw a rivet here. 

And he's drawing really sloppily. It's kind of tilted off to the side. It's kind of misshapen. So what he does is then he holds down a switch and indicates a couple of these lines to the computer system, indicating that he wants these lines to be mutually perpendicular. So the system runs an iterative solver, kind of Wills the lines around and figures out how to turn them into something that's mutually particular how to turn them into a rectangle. 

So. Basically, 

the system doesn't know anything about rectangles. He was able to get it to draw a rectangle by directly applying a set of constraints. And what makes this a program as opposed to just a picture is that these constraints are dynamically maintained. So he's got his rivet that he drew, and he resizes this corner of it and kind of resizes some other things. The solver kicks back in, turns it back into a perfect rectangle. 

So essentially he's created a program that draws a rectangle, but he didn't do it by writing code. He did it by directly manipulating the data and directly applying a set of constraints to them. And so this is a kind of simple example. And then he went off and did fancier things like here's a bridge simulation. So it actually simulates the physics of a bridge. He drew this by hand. The numbers here represent the tension in those spans of the bridge. 

And he can vary the weight that the load that's hanging off in the center of the bridge and it kind of deforms, and the system sketchpad system doesn't know anything about bridges. He created this bridge simulation program by directly drawing it and by directly applying a certain set of very general constraints. 

So I definitely see this as something that's going to be really important in 34 years from now. I can imagine programming by directly manipulating j structures and letting that build up the, the code, but especially for things that are visual or physical like this. So if you say in a few decades, we get some sort of document format on some sort of web of computers, I guess. 

I'm sure we're going to be creating all those documents by direct manipulation. There won't be any like markup languages or style sheet languages right ? That would, that would make no sense. Ivan sutherland showed us, showed us how to do it back here in 1962. Soit's all going to be direct manipulation in the future and that's going to be fantastic. 

So the second thing I want to talk about is programming using goals. 

So we saw a little bit of this with sketchad's constraint system. So Ivan suddenly wanted to draw a rectangle. He didn't write a procedure to draw each side of the rectangle. He applied a set of constraints, and the system itself kind of figured out how to draw that rectangle. So he kind of said what he wanted. I want things to be mutually perpendicular. He didn't say how to do it. The solvers figured out how to do it. 

So another great example of that that just came up a few years ago, Carl hewitt is doing the system called planner, which is really great. It actually goes in both directions, so it can reason forward. Procedurally, it can reason backwards from goals. So if you tell planner that apples are red, then if you give it an Apple, it knows, aha, it's red. But you can also say I want something red and it'll say, 

oh, let's try an Apple. So you can express your program in terms of the goals, the results that you want from the program, but you can also provide procedural strategies for meeting certain types of sub goals. Really, really interesting way of thinking about programming, and this LED to another system. Few years later called prologue, which just kept the backwards part planner. So I'm prolloggging spaces program as goals and the system itself uses search or whatever to try to figure out how to meet those goals. 

So this is leading to a genre of programming that's called logic programming, but that's, that's not really the important part here. What's important is expressing your program as what you want to do, not a set of instructions on how to do it, letting them impute itself, figure out how to do it. 

Another example of that same sort of concept is pattern matching. So I'm sure you remember you all remember snowball. It's the text manipulation language. If you have a bunch of text you want to shoot through, you throw a snowball script or program at it. And snowball has built in features for pattern matching, so you could express patterns that you want to match against the text. A little bit later, 

Ken Thompson, so bell labs working on this system they call unix. 

I know, right, unix, but he adopted k's notion of regular expressions to do pattern matching on text. 

So when you have pattern matching, if you want to digest a big chunk of text, you don't go and write a parser that kind of goes procedurally through it. You provide a pattern, this kind of template. This is the sort of thing I'm looking for, and the system itself figures out how to match the text. Against that pattern. 

So. 

All of these examples, 

sketch pads, constraints planner, prologue, pattern matching, again, they're all all examples of giving the computer high level goals, saying here's the sort of thing I'm looking for, letting the computer itself figure out how to do it, and we're seeing a little bit of that sort of thing and optimizing theilers but I think it's gonna be really prevalent in a few decades from now. And the reason that this is going to be so important to school directed stuff has to do with this, 

this idea that lick lighter is kicking around. So, as you all know, lickliter is heading up arpa, the government funding agency. And he's been pushing this idea of a global network of computers, just taking all the computers in the world and hooking them up to each other. And he calls it the intergalactic computer network because he knows that engineers always deliver the minimum. So if he asks for a network that spans the Galaxy, 

he hopes to at least get one that spans the world. And people are calling this the AR ed net. Now it's turning into some sort of interet. It's kind of a cute idea. Might work. And when you have this kind of global network of computers, you run into what llder calls the communicating with aliens problem. 

So he put it here. The problem is essentially the one discussed by science fiction writers. How do you get communication started among totally uncorrelated sapient beings ? And I'll explain what he means by that. 

So say you've got this network of computers and you've got some program out here that was written by somebody at some time in some language that speaks some protocol. You've got another program over here written by somebody else some other time, speaks a totally different language, written totally different language. These two programs know nothing about each other. 

But at some point. 

This program will figure out that there's a service it needs from that program. 

That they have to talk to each other. So you've got these two programs don't know anything about each other, totally different times. And now they need to be able to communicate. 

So how are they going to do that ?, 

Well, there's only one real answer to that that scales that's actually going to work, which is they have to figure out how to talk to each other. 

They need to negotiate with each other because they have to probe each other. They have to dynamically figure out a common language so they can exchange information. And fulfill the goals that the human programmer gave to them. So that's why this goal directed stuff is going to be so important when we have this Internet is because you can't write a procedures, because we won't know the procedures for talking to these remote programs. 

These programs themselves have to figure out procedures for talking to each other and fulfill higher level goals. So this, if we haven't this worldwide network, I think that this is the only model that's going to scale what won't work, what would be a total disaster. 

Is I'm going to make up a term here, API, this notion that you have a human programmer that writes against a fixed interface that's exposed by some remote program. First of all, this requires the programs to already know about each other. 

And when you're writing this program in this one's language, now they're tied together. So the first program can't go out and hunt and find other programs that implement the same service they're tied together. If this one's language changes that breaks this one, it's really brittle, doesn't scale and. Worst of all you have, it's basically the machine code problem. You have a human doing low level details that should be taken care of by the machine. 

So I'm pretty confident this is never going to happen. We're not going to have APIs in the future where we are going to have. Are programs that know how to figure out how to talk to each other, and that's going to require programming and goals. 

The third big idea that I want to talk about is spatial representation of information. So today, our programs are basically lots of lines of text, a big file full of lines of text, and that makes sense when your program is on a stack of punch cards or it's a paper tape or a magnetic tape. Very linear media makes sense to have your program in this kind of linear form. If you're using a teletype, then telltype is made for spitting out lines of text. 

That's what it does. So of course your programs are going to be in lines of text. But as I mentioned, people are doing something really wild and crazy right now, which is hooking video displays of computers. And when you have a video display hooked up to a computer, you can start thinking of your computer as kind of this very dynamic sheet of paper where you can represent things spatially. So. 

Doug engelbart over at Sri. 

Has a system that he calls online systems. He gave a big demo five years ago. You might have seen it, and there's a lot of really remarkable things about the system. One of the most remarkable is this notion of displaying information over a screen, over a video screen. So he has this device, this device called a mouse, where you kind of rolled around the table and it's kind of hard to explain, but you can use this to point to different parts of the screen and indicate that you want more information about something that you're pointing to. 

And it also has this notion of different views of information. So you can see here he has some data in a list and they can flip that over and look at that same data as this kind of two dimensional diagram. So really starting to think about how can we represent information dynamic information spatially. 

Another great system come about the same time. Coming out of the Rand corporation was called grail, and this is a system for programming using flowcharts on a video display and the input device here is a stylus on a tablet and you can drop these flowcharts and let me show you how that works. 

The programmer is drawing this box and just kind of totally free handing it, and he draws a box and the system recognizes that as a box and turns it into a flowchart box, so assigns semantic meaning to these drawings that he's doing. 

He wants to give it a label, so he just starts writing letters. The system recognizes his handwriting. 

1968 system recognizes handwriting. Turns it into text. 

Here he connects up this box to that one with a line and so on. So it's all very direct manipulation. If he wants to get rid of this line. He just kind of scribbles it out and goes away. And so really thinking about what programming means when you have a video display, when you can express things in two dimensions. 

But when I'm talking about spatial representation of information, I'm not just talking about things like flowcharts. So xerox has a little research center in Palo Alto. There's some kids over there working on something that they call smalltalk. And in small talk, the source code is expressed in in text, but there's no big long text file with a whole bunch of whole bunch of code in it. It's organized in a spatial fashion, 

so here's what they call a browser. So in this list here, here's all the collections of classes, here's all the classes in that collection, here's all the protocols in that class, here's all the methods in that protocol, and here's the source code for that particular method. So the method definitions are text, but they're not one huge line of text. They're organized spatially so you can get around the system very quickly and see what's going on. 

So between anglebart ands grail, 

small talk, these very different ways of representing information spatially. So I'm totally confident that in forty years we won't be writing code in text files. 

We've been shown the way and as a side note. 

All of these systems I just showed you Engel, bart system, grail, smalltalk, this thing that's going on at university of Illinois called plato also really interesting system. These are part of this new wave of interactive computing. Where you sit down to the computer and you're actually interacting with the computer in real time. And these guys know that they're trying to prove out this new concept. 

And so they've designed the system from the very bottom to have an immediate response. The user interface is always immediately responsive. You interact with anything, you immediately get a response. So it's kind of simulating a physical object. And so if interactive computing takes off, and I think it will, then I think it's pretty obvious that in forty years our user interfaces, if you interact with them, 

you'll never experience any kind of delay or lag. Right, because these guys proved how important it is to have an immediate responsive UI and they were doing this in the, in the sixties. So as our computers get a million times faster, obviously there's no reason to have any kind of delay or lag in the operating system in the user interface. So that's going to be really exciting. 

The fourth thing that I want to talk about. 

Is parallel programming. 

So today our programs are basically a sequence of instructions. A computer do this, then do that, then do that, then do that. 

One of the reasons that we program the sequential model has to do with the hardware. 

So we've been using this computer architecture called the von neumann computer architecture, where you have a processor and then it's hooked up to a big memory and it's fetching words from memory and. 

So the sequential programming model makes sense when you just have one process, can only do one thing at a time, you give a list of things for the process to do, and it just kind of does each one of those. 

One characteristic of the von neumann architecture, though, is that. 

Most of this memory is idle most of the time, so you've got this little processor over here and it's kind of processing as fast as it can. But only one word of memory is ever being accessed. The rest of the memory is just kind of sitting there waiting and. That works when when your processor is made out of vacuum tubes or relays and it's kind of big and expensive and your memory is made out of core or rotating drum is also big and expensive and different, 

then you can kind of get away with that, but. We're starting to see. An incredible invention coming into the field computing, computing right now, which is I think going to change everything, and that is the integrated circuit semiconductor integrated circuit. 

So this is a thing that a company called Intel made. It's called the microprocessor, and it's an entire processor on a single piece of silicon. 

So the entire processors just made out of transistors, and a transistor is just a little picture you etch into silicon. And the entire circuit is just one big complicated picture that you etch into the silicon. So our processors are just made out of transistors and silicon. Our memories as well are also going to be made of transistors on silicon. It's all the same stuff. 

So when you look at the von neumann architecture, from that perspective, you've got these transistors over here that are working really hard to processing things. You've got this huge array of transistors over here, most of which are just kind of sitting. Waiting. They're not processing. They're not doing anything. And so. 

If you want to. Put those transistors to work if you actually want to maximize the amount of processing that you're going to get out of a piece of silicon. 

You need to start looking at things that are more like this. 

So what computers want to be on silicon is they want to be lots of little computers, like a huge array of tiny little computers with their own process, their own little state, doing their own thing, communicating with each other. That's how you maximize the amount of compute per area of silicon. And the scales. So when the transition gets smaller, when the silicon diary gets bigger, you have all this extra space, 

you just fill it up with more processors done. Really easy. 

This is the kind of architecture that we're going to be programming in the future. 

Unless, you know, unless Intel somehow gets a stranglehold on the bracken process of the market and how it pushes this architecture forward for thirty years. But that's not going to happen. We're going to be programming on these things. And when you have this hardware, you have to start thinking about how do, how do we program on that, what's our programming model for this sort of hardware ?, 

And the way that we do programming today. 

Is with threads and locks. You have a few sequential threads of control, and you kind of pretend that they're going in parallel by multiplexing them onto a processor and they try to lock each other out from shared resources. 

Like this is never going to work, right ? This does not scale. You can't reason about hundreds of threads all banging on the same shared memory at the same time threads and locks. They're kind of a dead end, right ? So I think at forty years we're still using threads and locks. We should pack up and go home because we've clearly failed as an engineering field. So if it's not threats and locks, then what's going to work ?, 

And Carl hewitt, that's the same Carl hewitt they did. Planner came up with this idea that he called the actor model. 

So the actor model is a model of computation that's inspired by physics. So in physics you've got all these particles and all the particles are just independently doing their own thing. And they have their own little state and they interact with the ones that around them. And Carl, he was thinking of computer processes in the same way. You got a whole bunch of processes. They're all kind of asynchronously doing their own little thing. 

They little state and they're sending messages to each other. So really interesting, really new and exciting way of thinking about programming. So a lot. It's kind of heating up right now. J kh over in France has some ideas. I think Tony hor getting into it with something. He's going be calling communicating sequential processes and maybe even ramen Miller is going to join the party. So really exciting stuff happening here. 

Now for this talk. The details of this particular, these particular models don't really matter. 

I do think it would be kind of cool if the actor model was picked up by the Swedish phone company or something. That would be kind of. Weird, but. 

But what matters here is we are going to have massively parallel hardware. We need a sound parallel programming model that fits the hardware, and something like this is going to be what we're going to be using. 

So those are the four things I want to talk about. 

Direct manipulation of data, something like the sketch pad where you're drawing pictures dynamically, adding constraints to those pictures, directly, manipulating the data structures instead of writing instructions for the program. 

Programming using goals and constraints. Things like sketch pads, constraints, planner and prologue. 

Regular expressions, other types of pattern matching where you're telling the computer what you want to do, and the computer itself has solvers that figure out how to do that. 

Spatial representation of information. 

We're not going to have text files anymore. We're going to be representing information spatially because we have video displays and. 

Fundamentally parallel ways of thinking. Parallel hardware, parallel program models. No more threads and locks. No more sequential thinking. 

So those are the four things I want to talk about and. 

You know, I've tried to make some predictions about the future and you can't really predict the future, right ? So these are some good ideas. I don't know what's going to happen to them. Ideas kind of split and merge and go in and out of fashion. So, you know, anything could happen. 

But I do think that it would be kind of a shame if in forty years we're still coding in procedures, in text files, in sequential programming model. 

I think that would. That would suggest we didn't learn anything from this really fertile period in computer science. 

So that would kind of be a tragedy. 

But. 

Even more of a tragedy than these ideas not being used would be if these ideas were forgotten, right, if if anybody were ever to be shown this stuff and actually be surprised by it. 

But even that's not the biggest tragedy. That's not the real tragedy. The real tragedy would be if people forgot that you could have new ideas about programming models in the first place. 

So let me explain what I mean by that. 

Here's what I think the worst case scenario would be is if the next generation of programmers grows up never being exposed to these ideas. The next generation, the next generation of programmers, grows up only being shown one way of thinking about programming. So they kind of work on that way of programming. They flesh out all the details. They, you know, kind of solve that particular model of programming. 

They figured it all out and then they teach that to the next generation. So that second generation then grows up thinking, oh, it's all been figured out. We know what programming is, we know what we're doing. 

They grow up with dogma. 

And once you grow up with dogma, it's really hard to break out of it. 

Do you know the reason why all these ideas and so many other good ideas came about in this particular time period in the sixties ? Early seventies ? Why did it all happen then ?, 

It's because. 

Technology. It was late enough that technology kind of got to the point where you could actually kind of do things with computers, but it was still early enough that nobody knew what programming was. 

Nobody knew what programming was supposed to be and they knew they didn't know. So they just like tried everything. Their minds were totally free and they just said maybe we could Pro like this. Maybe we could program like that. They just tried anything they could think of. 

So. The most. 

Dangerous thought that you can have as a creative person. Is to think that you know what you're doing. 

Because once you think you know what you're doing. You stop looking around for other ways of doing things and you stop being able to see other ways of doing things. You become blind, you become like like these guys over here, kind of coding along and binary. Someone shows them assembly language, so someone shows them foran and they can't even see. It just goes right over their head because they know what they're doing. 

They know what programming is. This is programming that's not programming. And so they totally Miss out on this much more powerful way of thinking. 

So the message of this talk, you know, it's not really, it's not really the stuff, right ? The message of this talk is. If you don't want to be this guy. If you want to be open and receptive to new ways of thinking, to invent new ways of thinking. I think the first step is you have to say to yourself. 

I don't know what I'm doing. We as a field don't know what we're doing. 

I think you have to say we don't know what programming is, we don't know what computing is, we don't even know what a computer is. 

And once you. 

Truly understand that and once you truly believe that. 

Then you're free. And you can think anything. 

Thank you. 

# Essay 2

давайте знакомиться. меня зовут антон. мы сегодня поговорим о том, как можно верифицировать на перспективность ит тренды. примеры будут прежде всего из автоматизации тестирования. но вообще этот инструмент можно применять для любой ит дисциплины и не только ит дисциплины. фактически для чего угодно короткое. выступаю как представитель компании дипиай старушенция, является учредителем. также я работаю хитрым, менеджером компании и память системс. 

что-то вроде менеджер по стратегическому развитию автоматизации на просторах снг и есть целых четыре сообщества. я являюсь. организаторам сообщества автоматизации сообщества сипло сплав разработчиков и ниже сообщество идти специалистов переехавших из разных стран в беларусь. и метод сообщества по открытию новых ит сообщества есть и. так что к чему оно приведет? сколько идти сообществ, мы скорости наплодили мы увидим. 

поговорим мы вот наш план беседы вообще слайдов много, то есть в короткой версии около двухсот. поэтому мы все равно все никак покрыть не сможем. но бояться не стоит. во-первых, у вас останется презентация людей, есть много полезных материалов. во-вторых, я написал статью на русском и английском языке, посвященную этому вопросу. и она тоже будет прилагаться. если мы точно не успеем, если и точно не успеем, то вы сможете дальше читать. 

если вам действительно будет интересно. почему эта проблема актуальна, и я скажу на своем собственном опыте. сначала я около четырёх лет писал на ассамблее, да еще на специфическом варианте ассамблея на немецком языке под немецкие промышленные контроллеры для агрессивных. там не было команды сер. там была команда ахтунг, и вот этим к этому ахтунг я посвятил четыре года своей жизни, потом я пару лет писал на языке лист и. 

научился мастерски открывать и закрывать скобки. и как применить сейчас этот богатый опыт, я даже не знаю, ну разве что филигранная владение смайликами. вот да, это это единственное, как можно сейчас применить в разумных целях. дальше много лет писал на сипло. спас, а года четыре назад всех предал и занялся автоматизации тестирования. и вот даже мой путь показывает. вроде бы все получилось. вроде бы я себя войти как то реализовал замечательно чувству, но уверен, что это не оптимальная траектория к той точке в корее, которая нахожусь. 

значит вот я лично прочувствовал, что я много раз шел не туда. много раз пытался зайти в тупик. то же самое касается конкретных проектов, над которыми я работал. скажем, сипло спас проекты. тоже целый ряд из них был заведомо легаси, заведомо утопично. тем не менее, я инвестировал свое время свои силы, и хочется. чтобы ваша карьера построилась значительно быстрее и эффективнее. какое решение? то есть решение это дать некий инструмент. 

который позволит вам отбросить заведомо, не скажем так, заведомо тупиковой эволюционной ветви. в рамках вашей карьеры в рамках того либо иного инструмента, конечно. можно было построить доклад на базе каких-то журналов. он был бы замечательным и актуален в течение года. через год этот доклад можно было бы отбрасывать и строить новый, поэтому лучше дать инструмент. он не предполагает четкости однозначностью математической, а нам это и не нужно. 

мы ведь не занимаемся фундаментальной математикой. нам главное из всего множества возможностей отбросить заведомо тупиковый, а в тех считанных на пальцах, которые мы можем пересчитать. мы сами разберемся, что нам более интересно, чем нам. мы поговорим о диалектике гегеля о пяти признаках сложных систем по крайней будущее. и о моем любимце законе эротических компенсаций седого, который я очень часто упоминаю. 

вначале у нас будет небольшая, потому что теоретическая часть, а потом мы перейдем к практическим вопросам. вот что такое диалектика дизеля фактически. развитие то есть существует формальная аристотелевская логика. а это некое дополнение к формальной аристотелевской логике аристотелевская логика то. с чем мы привыкли работать, работает со статикой, если можно так выразиться, я очень упрощаю. возможно, те, кто читал дети или глубоко выказался, сейчас аж передергивает. 

но я пытаюсь как то очень упростить. а вот диалектика работает с динамикой, а все вокруг нас динамично развивается. и важно, насколько кино эффектней и чем чем фотография вот настолько же диалектика гегеля эффективнее, чем классическая аристотелевская логика. директор первого открывателя диалектики думаю, что все мы слышали выражение все течет, все меняется. так вот, даже в рамках древней греции гераклита называли темным, то есть непонятным и великий сократ, о котором мы все точно слышали. 

даже он иероглифы не вполне понимал, хотя очень глубоко уважал. вот с диалектикой все то же самое. на первый взгляд она выглядит сложный и непонятный. есть такой философ тоже очень известный и. это уже философ. в середине девятнадцатого века. так вот это прямая его цитата. я думаю, что те места у деятеля, которые я не понимаю. он сам тоже не понимает. и. дальнейшая сатара неспособность понять великого человека деятеля есть, мой позор несчастья. 

вот на первый взгляд звучит, что как-то очень грустно, но я не призываю считать непосредственно деятеля и даже слушать какие-то адаптивные лекции по диалектике. вот мы сейчас на пальцах попробуем с этим разобраться, и для старта этого будет достаточно. то есть мы все знаем противоречивые и внутренний на первый взгляд. противоречивые выражения, которые тем не менее каждый из нас согласится, что они правильно, абсолютно корректно, слишком хорошо. 

или делаешь делаешь хорошо, результат выходит плохой и противоположности сходятся или противоположности притягиваются. ну, звучит странно. но на самом деле на жизненный опыт подсказывает, что это верно. вот как скотт фиджи райт выразился о диалектике. я не знаю ли, владел ли вообще этим термином скот фиджер альт, но, по сути. он дал определение диалектики признаком. первоклассных мозгов является способность держать в голове две взаимоисключающие мысли, одновременно не теряя при этом способности соображать. 

фактически это диалектика просто сформулировать. образом и диалектику надо, то есть ее нет смысла, как бы учить зазубривать есть смысл. вот ее немножко подумать взять на вооружение. а потом в процессе вот ее заточить. да и вот пример диалектики как раз в белорусском стиле я приехал из белоруссии. берегите лес, берегите бобров да вот, казалось бы, одновременно верное утверждение противоречивые. тем не менее. 

вот цельная единая ведь бобры тоже часть лесной экосистемы. и их однозначно нужно беречь. хотя открою страшную тайну никак не связано с диалектикой в белоруссии очень много бобров и попой, лариса мне бесконтрольно развилась и уже год. как делают из бобров колбасу различные мясные изделия, берегут лес и попробовать таким способом. и это тоже очень диэлектрик. вот сразу же определение, которое малопонятное это определение из википедии даже ничего, то более сложного. 

что существует диалектическая отряда, тезис, антитезис синтез и тезис. это некая идея теории или движения антитезис оппозиция к тезису, если выразиться более проста, то у всего есть две стороны у любой медали есть две стороны, и если только некий инструмент или некий подход однобокий. то как бы мы его не развивали это эволюционный тупик, он может занять свою нишу. он может быть замечательным здесь и сейчас и нам стоит с ним работать. 

но не стоит инвестировать массу своего времени. при этом есть одна сторона, есть вторая сторона, и следующий эволюционный шаг будет гарантировано операция на. и к ним добавлять и еще что то еще некую вишенку. яркий пример, как это можно применить? есть такое понятие, как виртуализация. и виртуализация бывает двух типов бывает непосредственно на железе. то, что называется виртуализация изначально, а есть такая логическая, да то есть эмуляция и все изначально существовало два этих подхода. 

и но сейчас все успешные решения внутри себя содержат оба даже посмотреть на современные процессоры. мы сразу видим характеристиках, сколько у них физических ядер, и сколько у них ядер виртуальных. то есть виртуализация работает уже опыт типа да эмуляция даже на уровне железа, а что говорить о более высоком уровне, соответственно если вдруг кто то из товарищей вам предложит, давайте сделаем стартап, мы сделаем филигранную вот виртуализации на базе железа или исключительно на базе эмуляции. 

вот с точки зрения диалектики гегеля это гарантированный тупик. то есть, возможно. этот продукт будет востребован сегодня и завтра, но он никогда не будет востребован в серьезной длительной перспективе. именно в силу своей однобокость, соответственно, любой успешный продукт по виртуализации должен содержать себе. и еще какую то вишенку вот это и называется диалектическая спираль было одно было другое. 

и потом, мы вышли на следующий уровень. который содержит себе и первое, и второе и компот нечто дополнительно. то же самое может касаться, например, языков программирования, ведь еще взять старые учебники и там прямо противопоставляются друг другу. вот есть языки компилируется, а есть языки интерпретируемое. у одних такие плюсы, у других другие плюсы и. а давайте посмотрим на все современные языки программирования. 

почти все из них содержат как часть компьютерную, так и интерпретируемое некий ил. у нас есть компиляция. на этом уровне происходит целый ряд оптимизации несколько проходов, то есть все очень очень сложно. а дальше происходит интерпретация этого ила, в рамках которой тоже происходит некая рон тайм оптимизации. прочие прочие прочие прочие значит если вдруг появится какой то язык программирования только компилируется или только интерпретируемое это не значит, что им не нужно пользоваться. 

возможно, он решит ваши текущие задачи, но гарантировано не стоит ему много времени, потому что он одна боти в нем. если бы одна сторона медали либо другая. а за будущим совместная компиляция интерпретация и еще что-то, да сверху. вот как, например, если говорить о дот найти либо джава как рон тайм оптимизация, когда некие куски кода прямо вот которые заведомо не будут выполнять, просто выбрасываются из нашего. 

а. и есть несколько законов единство и борьба. противоположностей переход количества в качество и отрицание отрицание на первый взгляд ничего не. терминология очень специфическая и давайте поглубже рассмотрим вот закон единства и борьбы. противоположности специально беру пример сразу из википедии. изначально ничего непонятно. единственная борьба противоположности. кто с тем борется, что такое противоположности, являются ли они вот то, что мы понимаем за черное и белое противоположностями нет. 

куча вопросов, и нам дают несколько примеров. которые нам мало чем помогают, корпускулярно головой, идеализм, ну хорошо биологическая эволюция борьба наследственности и изменчивости замечательно, но все равно непонятно. и вот пояснение более простым языком. то есть борьба условный термин. который просто показывает. что одно в каком то смысле противоречит другому и активно взаимодействует с. да это вот из серии есть хочется и худеть хочется и всего хочется. 

помните такого киногероя. вот это есть единственная и борьба противоположности вроде бы противоположности, а хочется и того и другого побольше. примеры противоположности и их борьбы вверх и низ все, что имеет вверх имеет и низ. и одно мы определяем через другое. и это две разные стороны одного и того же предмета не может быть предмета без верха и низа. то есть это единство и борьба. с одной стороны они противоположные понятия. 

с другой стороны они едины, как часть некоего сущности, и. по другому с ними работать невозможно. а вот, например, у шара в космическом пространстве когда у нас нет некой системы координат. хотя бы получается, что верх нет. то же самое лево право абсолютно идентичным. то же самое рабочий и работодатель. с одной стороны, рабочий хочет меньше работать и больше получать. да, в идеале вообще не работать и получать все, что только можешь унести, работодатель хочет противоположное чтобы платить поменьше. 

а сотрудник работал побольше. в итоге мы находим некий компромисс между желаниями сотрудника и работодателя. и ну, это и есть наша сегодняшняя с вами работа, а друг без друга мы работать не можем, да и вообще существовать не можем. вот тоже пример единства и борьбы. противоположности тот же самолет. с одной стороны. на него действует сила тяжести, и он пытается упасть на землю. с другой стороны. есть подъемная сила, благодаря его там быстрому движению вперед, и он вот и в итоге вроде бы противоположности, но при этом они едины самолёт в процессе полета постоянно с этими двумя частями одного целого и живет, и существует. 

стремление к счастью. с одной стороны все хотим быть счастливыми. а с другой стороны, как минимум дорога, к счастью, приносит очень много хлопот, а скорее всего огорчений. кто вспомнит влюбленность, вроде бы это вот дорога, к счастью. а сколько трудностей, если не сказать геморроя, мы на этом светлом пути себе нажимаем вот почти все переживания, седые волосы и сердечные приступы у вас связаны именно с этим. 

там тепло, холодно. опять же вот здесь яркий пример, что поскольку у нас на планете существует перепада температур. то мы эти противоположности сформулировали. и на наших же планете пока не было. скажем, там погружений в воду и таких сознательных подъемов горы не было понятия воздух разряженный неразрешенный да какой-то концентрированный либо либо разряженный. то есть противоположности. с одной стороны это объективная реальность, другой все зависит от контекста. 

то же самое хорошо плохо, а не часто, как отрицание себя. да то есть там не знаю, больно плохо, отсутствие более хорошо и так далее. и вот это называется диалектические пары. то есть все на свете как бы состоит из двух пар из какой то веревки, вот которая их сочиняет и каждая каждая часть вот тянет тянет в свою сторону. вот примерно так же тенденции, чтобы привести пример. не знаю, пусть дерево будет расти, все выше, выше и выше. 

ведь там много света будет активно развиваться, фотосинтез. с другой стороны, если у него будет слишком высоким, ветер сможет его сломать. вот у нас есть противоположные тенденции. да, тенденция к росту и максимальной высоте, и с одной стороны тенденция к максимальной заземление. чтобы дерево никоим образом не. и мы находим некая разумный компромисс, некая разумная размер дерева в зависимости от целого ряда фактов. 

то же самое. вот таких примеров можно привести множество, и все это ложится, в том числе, на компьютер сайнс абсолютно однозначно. и вот вы потом совсем этим ознакомитесь. то есть противоположные тенденции всегда сдерживают друг друга, чтобы самолет да ни в землю не вошел ни в космос. не улетел противоположности, которые сдерживаются. да то же самое с нашей планетой. с одной стороны все хочет собраться в эту точку благодаря гравитации. 

с другой стороны, все хочет разлететься во все стороны, но вот они друг друга уравновешивают. и мы живем на нашей круглой. следующий закон переход количественных изменений в качественных тоже пример из википедии. не особенно нам помогает превращение лед, вода. пар ну вроде бы все просто со школьных времен понятно, совершенно непонятно, как это применить в мирных целях. да вот пример такой милитаристский. 

у врага есть танки. значит танки нужны нам врага, пять тысяч танков. давайте и мы сделаем пять, а лучше десять. но вообще непонятно, хватит ли нам десяти тысяч танков. давайте сделаем пятьдесят тысяч в итоге. эти танки должны каким-то образом добраться из пункта а в пункт б. у них должно быть достаточно топливо у них должны быть обучены экипажи. в итоге они съели всё топливо экипажа недостаточно обученная, не организовали пробку, и в итоге мы сконцентрировать силы ни на каком участке не можем. 

и хоть у нас танков десять раз больше, мы успешно проигрываем сражение, и получается, что нарасти в силы сверхмеры. мы остались надели бессильными абсолютно без. то же самое помните случай, в так сказать под конец ссср. когда маленький легкий самолетик взял и приземлился на красной площади. как такое могло произойти, а система пво советского союза была настолько мощной, что все эти сверх сверх серьезные фильтры, да, срочно структуры. 

пока они вот реагировали, вот этот кукурузник смог спокойно прилететь и приземлиться. да и то же самое получается, что вот переход количества в качество мы наращивали наращивали. наращивали нашу систему пво до такой степени, чтобы она стала бесполезной. по крайней мере, для вот этих маленьких одиночных целей тише едешь дальше будешь. на всех машинах современных практически на всех стоят чипы по ограничению скорости. 

да, но возможно может идти четыреста километров. в частности, у нее ограничения, что выше сто восемьдесят, она не может набирать скорость именно потому, что мы хотели добраться как можно быстрее, разогнались до двухсот километров час. не справились по воротам, вошли в стену и в итоге не приехали никуда в лучшем случае. тоже вот яркий пример. и таких примеров множество. количество в качестве поэтому и говорят, что все хорошо в меру. 

а мера это соответствие количества твоих действий тому результату, которого ты хотел ими добиться. вот это количество качества, и закон отрицания отрицания еще более загадочные и примеры закипели, который под которого нам вообще не легче вот какой то математический пример смотрите вот. ну хорошо, с точки зрения математики вроде бы все правильно, но все равно непонятно. а вот превращение лед. вода, пар, опять же, мы видим сразу же взаимодействие. 

взаимосвязь законов. а причем тут. а вода при кипении превращается в пар и тем самым отрицает воду. но ведь пар это все таки это не жидкость, это другое. агрегатное состояние было одно стало совсем другое. при этом пар рано или поздно превратится в конденсат и снова станет водой. да то есть вот вернётся в себя. это есть отрицание отрицание, то есть переход сначала в новое качество. а потом еще одно новое качество, которое либо вернулось назад, либо перешло на следующий уровень. 

да, если эта спираль у нас была вода с примесями, мы её вскипятили, потом сконденсировались. и вот мы получили воду без примесей. мы вроде бы вернулись к тому же, но спираль вышла на другой следующий. и это также можно назвать переход в новое состояние. и здесь тоже множество различных примеров. я думаю, вы с этим сможете ознакомиться в дальнейшем. но чем диалектика. вот сразу заставляет интересно быть, на мой взгляд. 

вот мы даже эта стандартная картинка одна из очень популярных в интернет. и мы сразу видим надпись постижение полиморфизма системы. ох, как все это близко к нашей работе. оказывается, еще дети говорила полиморфизм и система. а мы то думаем, что занимаемся инновациями. это применимо только только к нам, и также есть пять признаков сложных систем по городе бочин. то есть это просто любая система, успешная в эволюционном смысле должна этим признакам либо соответствовать пяти. 

да, если она не соответствует, то есть совсем грустно. и закон седова. опять же, здесь много слайдов. я остановлюсь на его самой простой формулировке такой прикладной. то есть для того, чтобы получить разнообразие на верхнем уровне. нужна строжайшая, стандартизация на всех ниже лежащих уровнях иерархии. и наоборот, если на каком-то ниже лежащем уровне мы получили многообразие. то все вышестоящие уровни автоматически разваливаются. 

сейчас мы об этом немножко поговорим. семидесятые и бум языков программирования в семидесятые ежедневно выпускалось несколько языков программирования. и это ведь не просто язык сам по себе это вся необходимая инфраструктура набор стандартных библиотек. компиляторы, инструменты для отладки, куча всего. а сколько было в семидесятые. но точно меньше. чем сейчас. то есть очень немного и получалось, что разнообразие верхним уровнем иерархии были как раз такие языки программирования, а по на каждом языке были написаны. 

не знаю единицы или десятки или сотни, но никак сейчас не знаю. на джава на топовых языках миллионы программ, написанные успешно эксплуатируются. и если вдруг сейчас мы получим такое же разнообразие языков, а ведь мы применяем десяток ну, два десятка языков в этой сфере активно. если добавить сюда для целей какие-то специфические языки, вроде с кс и ссср пусть будет двадцать. если только мы получим разнообразие языков, то. 

значит, все вышестоящие уровни развалится, и мы снова вернемся в семидесятые. хотя судя по картинке не так и плохо восьмидесятые сетевые протоколы то же самое восьмидесятых было куча сетевых протоков. а сейчас их остались единицы. и при этом мы с этим уровнем практически никогда не работаем. я как за свою практику на съезде пластмассовым принял участие в разработке двух сетевых протоколов. один из них для японских военных подводных лодок только с японией. 

об этом ни слова, что эта задача ушла на ут сорс. так вот, интернет без стандартизации невозможен. если мы сейчас вдруг захотим добавить десяток сетевых протоколов, то вся вышестоящая без этой стандартизации структура она развалится, она развалится в хлам. и получается, что, например, если вам предложат принять участие в разработке сетевого протокола благодаря закону седого, вы сразу понимаете это просто бумажка. 

что это может быть очень интересная задача и актуальной сегодня. но, скорее всего, в рамках вашей карьеры это достаточно тупиковая ветвь. вы не станете экспертом по протоколам, чтобы разрабатывать их и. да, в девяностые годы и с т. л. в девяностые годы появился сипло. спас, ну, скажем активно уже начал использоваться. а вот еще стандартные библиотеки даже на уровне таких вещей, как вектор. да там сэт мэр, то есть контейнеров. 

простейших их еще не было, и я сам участвовал в проектах. где были самые писаные эстелле что-то на макросов, что-то на какие-то безумие из указателей на указатели из указать. и при этом они все были нестандартны где то нумерация с нуля, где то соединиться где-то с двойки, потому что в начале мы храним какую-то секретную информацию. ну и как мне сегодня помогут эти знания. скорее всего никак. это, конечно, опыт. 

он, безусловно стоит чего-то, но не более того двухтысячной и мобильной операционной системы. честно говоря, я предпочитаю такие телефоны. то есть я до сих пор сейчас я ищу пару минут так, чтобы закончить мысль. и я не буду задерживать гостей. то есть было разнообразие операционных систем, выбрать себе телефоны и операционную систему было вопросом нет реальным. а сейчас мы работаем, по сути, с тремя основными мобильными операционными. 

да, там windows, android и ios, при этом андроид и иос на базе линуса. то есть уже мы помним про стандартизации. которая вот седовым говорит, что она необходима. при этом windows. очень microsoft тоже активно идёт в сторону линокса, чтобы иметь нечто общее, чтобы быть обратно совместимым. то есть microsoft идет в опыт сорс и идет на интеграцию с. в итоге в двухтысячные годы было, но сложно выбрать ус и мобильник. 

а сколько было программ на вашем телефоне. пять штук был замечательный калькулятор, органайзер и три игры вам змейка и еще пара. сейчас у нас операционных систем единицы, зато приложений миллионы и выходят ежедневно огромное количество. и какие мы выводы можем сделать, что вот закон седова плюс диалектика деятеля плюс пять признаков сложных систем это та самая лакмусовая бумажка. которая позволит отсеять большинство некорректных цен так тупиковых ветвей эволюции. 

вот как так беззубый тигр. он в свое время был прекрасен, но вот с точки зрения эволюции уже тогда было понятно, что это. и вот дальше идет как раз очень много детальных примеров по из автоматизации тестирования, как все это применить, но времени у нас, к сожалению уже нет, но мне казалось более важным застыть внимание на базе на диалектике. вот других вопросов, потому что они самые сложные, а все остальное. 

если вы научитесь применять, вы сможете применить это сеять сами эта презентация на русском и на английском языке будет выложена в ближайшее время. а также статья на русском английском языке и все то, что я не успел рассказать сегодня в рамках нашего краткого общения вы сможете прочитать в статье надеюсь вам было интересно. надеюсь, вы это примените и ваша карьера будет гораздо более ровной и последовательной, чем вот мой вечный зигзаг удачи на этом большое спасибо. 

смело задавать вопросы и большое коллеги. так вопросы какие то наверняка. 

не, срок. 

макаров игорь о, не слышно. макаров игорь анатольевич сервис. у меня не вопрос. у меня несколько дополнения, потому что сейчас вы очень много рассказывали про диалектику. если вот слушатель воодушевляться откроет сейчас гегеля, они наверняка подумают, что вы их обманывали. так что, наверное, стоит сделать уточнение, что не нужно прям вот сразу эту книгу открывать нужно начать какого-то более приземленного материалистического, может быть пониманию, безусловно. 

то есть здесь вот до этой презентации, то есть большое спасибо. очень хороший комментарий, то есть деятеля. я специально привел несколько цитата топовых философов. который говорит мы всю жизнь занимаемся философией. ведь деятеля не понимаем до сих пор. то есть, соответственно нам, но я точно не советую начинать гибели и даже, наверное, заканчивать деятелем не советую. но есть вот очень простые некоторые источники у меня там будут. 

плюс действительно вот материалистический материалистическая диалектика диалектический материализм очень интересно и ни в коем случае. то есть будут линкин они будут изобиловала красными знаменами. другой атрибутикой неважно. как вы к этому времени и к этому подходу относитесь к социализму и коммунизму положительно отрицательно. это неважно. то есть это все можно отбросить. а вот послушать профессионалов там действительно, если доктора наук, которые читают лекции очень и очень стоит, поэтому будут лимфы и их пугаться не нужно. 

а гегель действительно лучше лучше отложить его на потом. опять же деятель был первооткрывателем. и поэтому вот он нащупывал эту мысль, которую у него постоянно ускользала. поэтому и книги объемные. и вот он с разных сторон заходит. и ты считаешь вот как-то вязнет во всем этом, я сам категорически не советую читать. большое спасибо за за. спасибо, еще вопросы. 

судя по вашему жизненному пути вы ушли от программирования, но пошли в автоматизацию тестирования программирования умирает, остается автоматизация тестирования. нет, нет, нет. хороший вопрос острый. нет, нет, нет, ни в коем. людям спрашиваю а вы верифицированы редко развитие. да да, конечно. но эта тема большого отдельного разговора на самом деле еще в воскресенье будет мастер класс, посвященный вот метрика. 

я его буду проводить. и конечно дом мастер класса. можно мне попытаться задать. ну как и вообще в кулуарах сегодня. завтра самые разные вопросы. то есть я их подробно расскажу вообще на самом деле сегодня автоматизация тестирования это все более инженерная дисциплина, она все ближе к программированию. а я, честно говоря, уже достаточно давно ушел даже не в разработку и автоматизацию, а в менеджмент. 

а это вот из серии да какая разница, каким менеджментом заниматься. в общем то из одной области ты это более менее понимаешь. то есть я всё реже беру в руки шашку, в лучшем случае занимаясь разработкой архитектуры. либо по для автоматизации тестирования, либо просто пу, а вот непосредственно начало до конца, к сожалению пишу все реже. 

а я правильно понял, что мысль доклада основная в том ну просто мы весь доклад же не прослушали, что мысль доклада в том. что у нас на каждом уровне постепенно оформляются трендовые как технологии. да, но тем не менее, у вас нет ответа, а почему тот или иной тул стал трендовый и стал пришли в стандартам, или все таки есть фактически нет. ну вот фактически скорее мы идем от обратного. мы можем сказать почему тот либо иной инструмент не стал трендом. 

потому что он либо нарушил пять законов сложных систем градиента, либо нарушил закон европейской компенсации седого, либо не диалектический. то есть он не состоит из, скажем так, двух сторон медали. а несколько одна бог и не имеет возможности вот развиваться дальше. опираясь на одно на второе на третье. на самом деле вот в тексте статьи подробно рассмотрены, например, почему сиреневым стандартам, веб драйвер. 

почему эпин стал стандартом десять лет назад. отделение он был один из тридцати темных, лошадок и. и можно было легко сказать, как в анекдоте не смогла. я не смогла и населению делали ставки единицы. тем не менее, те оказалось бы мощные инструменты давно канули в лету, а сильным превратился в стандарт де факто. и судя по тому, как он развивается, он скоро станет вообще между юаням стандартом. уже сейчас эпизод, который по сути совместим и стоит на базе с ремнем. 

он работает со всеми мобильными, основными тремя мобильными операционными системами, и он уже заявил о поддержке windows. единственное, что он внутри себя опирается на так называемый windows драйвер от microsoft, который должен будет работать с любым юаней от от windows и от линукс. но пока, видимо, для microsoft это задача, неприоритетный он. то есть там много чего не работает. много работать нестабильно, но как только эта работа завершится селению, он станет не только стандартным. 

вот как сегодня в области автоматизации похоже. что сиреневым станет стандартным любой юаней автоматизации. и это не может не радовать. да. да давайте давайте да, в один вопрос и будем и будем делать вот, ну, может быть. финальный, да и потом в кулуарах задавайте любые вопросы ловите и пытайтесь, признаюсь. 

назад владимир я отдал им сумму. такой вопрос вот вы привели примеры, что, допустим, если сейчас он предложит разрабатывать сетевой протокол, то как бы это, по вашему мнению, тупиковый вариант. да и типа история показывает. что то приживается. а вот разнообразие. которое было раньше, оно уходит и остается только единицы. вопрос в том, что точнее два таких связанных вопроса. например, сейчас вы говорили, что было много языков программирования сейчас мало. 

значит ли это, что те языки программирования. которые разрабатываются сейчас, они, по вашему, являются уже тупиковыми и второй вариант. как понять, что, допустим, сетевые протоколы сейчас уже не стоит делать. а вот языки программируют все таки пока еще как понять, когда после который уже. да да, да. очень хороший вопрос. на самом деле это же как всегда дьявол в деталях. вроде бы да, три простых инструмента. 

а вот как ими филигранно пользоваться это всегда сложно. но вот что касается и языков и сетевых протоколов. если что-то новое и появится, и это будет перспективным, то оно должно быть диалектическим. оно должно содержать в себе и одну сторону медали, и другую, и нечто больше. если мы просто сейчас делаем третьим язык. вот есть джава и сша, и мы сделали просто третий язык на тех же рельсов. не добавив никакой вишенки сверху. 

почти наверняка это будет тупиком, потому что сколько усилий нужно приложить. чтобы разработать всю эту инфраструктуру и занять определенную экологическую нишу. если же закон диалектики нарушается в принципе, то это гарантированный тупик. вот если мы сейчас захотим разработать очередной, просто компьютерный язык, это будет либо дсс, который занимает свою нишу, и это замечательно. но он никогда не станет языком общего назначения, либо это наши наши какие-то игры, либо все таки он решение узкой задачи. 

языки там и статистический язык. и не знаю язык шаблонов в диком метапрограммирования не занимают свою нишу, но мы никогда не найдем писать вот все подряд на язык иди, например. поэтому мы сразу же отметаем недиагностированных варианты. то есть а что касается вообще, стоит ли заниматься языками и сетевыми, протоколами стоит заниматься тем, что сейчас находится на верхнем уровне иерархии верхний уровень иерархии. 

сегодня это причем. прежде всего его даже в парламенте бэтмена уже опирается на многие готовые наработки, то это это и это high level background. я бы так это назвал. вот это сейчас верхний уровень иерархии на этом уровне идёт многообразие сетевые протоколы. уже там двадцать тридцать лет как стандартизированные. значит, скорее всего почти наверняка работа будет. это будет какая-то ниша определенная, но не более того. 

соответственно, вы приобретете опыт. но поскольку это не живой продукт, либо вы навсегда останетесь в этой нише и будете его успешно использовать. но я мог бы остаться и писать на вот этом. и занимать определенную нишу еще десятилетиями. а может быть и больше. либо вы приобрели этот опыт, но приобрели его разово и никак больше не применили. вот я в детстве. например, закончил музыкальную школу по классу фортепиано. 

я, конечно, тешу себя мыслью, что я программирую вот моя беглость печати это исключительно заслуга пианино. но будем откровенны. с тех пор я даже пыль не протираю с инструмента. поэтому, скорее всего, эти инвестиции были почти в никуда. вот точно также с разработкой сетевых протоколов. а сейчас, я думаю, нам нужно заканчивать. очень извиняюсь, что не ответил на. спасибо, коллеги, совсем большое. напоминаю, что флора будет. 