format 221

classcanvas 128132 class_ref 128004 // Ordinateur
  classdiagramsettings member_max_width 0 end
  xyz 243.9 450 2000
end
classcanvas 128260 class_ref 128132 // Pion
  classdiagramsettings member_max_width 0 end
  xyz 400 76.3 3005
end
classcanvas 128516 class_ref 128260 // Plateau
  classdiagramsettings member_max_width 0 end
  xyz 784.5 -1.5 3011
end
classcanvas 129028 class_ref 128516 // Partie
  classdiagramsettings member_max_width 0 end
  xyz 15.3 -9 3017
end
classcanvas 129412 class_ref 128772 // Configuration
  classdiagramsettings member_max_width 0 end
  xyz 781.8 338.5 3011
end
relationcanvas 128388 relation_ref 128004 // <unidirectional association>
  decenter_begin 614
  decenter_end 351
  from ref 128132 z 3006 stereotype "<<ArrayList>>" xyz 454 383 3006 to ref 128260
  role_a_pos 502 333 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 128772 relation_ref 128900 // <unidirectional association>
  decenter_end 236
  from ref 128516 z 3012 to point 719 136
  line 130436 z 3012 to ref 128260
  role_a_pos 672 117 3000 no_role_b
  multiplicity_a_pos 687 148 3000 no_multiplicity_b
end
relationcanvas 129156 relation_ref 128260 // <unidirectional association>
  decenter_begin 134
  decenter_end 233
  from ref 129028 z 3018 to ref 128516
  role_a_pos 697 47 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 129284 relation_ref 128388 // <unidirectional association>
  decenter_end 907
  from ref 129028 z 3018 to ref 128260
  role_a_pos 353 291 3000 no_role_b
  multiplicity_a_pos 362 308 3000 no_multiplicity_b
end
relationcanvas 129540 relation_ref 129156 // <unidirectional association>
  from ref 129412 z 3012 to ref 128260
  role_a_pos 672 268 3000 no_role_b
  multiplicity_a_pos 687 302 3000 no_multiplicity_b
end
relationcanvas 129668 relation_ref 129284 // <unidirectional association>
  decenter_begin 86
  decenter_end 688
  from ref 129412 z 3012 stereotype "<<ArrayList>>" xyz 697 357 3012 to point 697 360
  line 129796 z 3012 to point 702 413
  line 129924 z 3012 to point 707 468
  line 130564 z 3012 to ref 129412
  role_a_pos 687 448 3000 no_role_b
  no_multiplicity_a no_multiplicity_b
end
relationcanvas 130692 relation_ref 128772 // <unidirectional association>
  decenter_begin 768
  from ref 128516 z 3012 to ref 128260
  role_a_pos 672 190 3000 no_role_b
  multiplicity_a_pos 687 211 3000 no_multiplicity_b
end
end
