package com.neon.intellij.plugins.gitlab;

import com.neon.intellij.plugins.gitlab.model.gitlab.GIPGroup;
import com.neon.intellij.plugins.gitlab.model.gitlab.GIPIssue;
import com.neon.intellij.plugins.gitlab.model.gitlab.GIPProject;
import com.neon.intellij.plugins.gitlab.model.gitlab.GIPUser;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface GitLabService {

//    @GET( "namespaces" )
//    Observable< List<GIPNamespace> > listNamespaces( @Query("per_page") Integer limit,
//                                                     @Query("page") Integer page );


    @GET( "groups" )
    Observable< List< GIPGroup > > listGroups( @Query("per_page") Integer limit,
                                               @Query("page") Integer page );

    @GET( "groups/{id}/projects" )
    Observable< List< GIPProject > > listGroupProjects( @Path("id") Integer groupId,
                                                   @Query("per_page") Integer limit,
                                                   @Query("page") Integer page );

//    @GET( "projects" )
//    Observable< List< GIPProject > > listProjects( @Query("per_page") Integer limit,
//                                                   @Query( "page" ) Integer page );

    @GET( "projects/{id}/issues" )
    Observable< List<GIPIssue> > listProjectIssues( @Path("id") Integer projectId,
                                             @Query( "per_page" ) Integer limit,
                                             @Query( "page" ) Integer page );

//    @GET( "issues" )
//    Observable< List< GIPIssue > > listIssues( @Query( "per_page" ) Integer limit,
//                                               @Query( "page" ) Integer page );

    @GET( "users" )
    Observable< List<GIPUser > > listUsers( @Query( "per_page" ) Integer limit,
                                            @Query( "page" ) Integer page,
                                            @Query( "active" ) Boolean active,
                                            @Query("order_by") String orderBy,
                                            @Query("sort") String sort );
}
