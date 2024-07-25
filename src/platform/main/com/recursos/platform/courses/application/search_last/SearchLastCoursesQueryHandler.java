package com.recursos.platform.courses.application.search_last;

import com.recursos.platform.courses.application.CoursesResponse;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchLastCoursesQueryHandler implements QueryHandler<SearchLastCoursesQuery, CoursesResponse> {
    private final LastCoursesSearcher searcher;

    public SearchLastCoursesQueryHandler(LastCoursesSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public CoursesResponse handle(SearchLastCoursesQuery query) {
        return searcher.search(query.total());
    }
}
