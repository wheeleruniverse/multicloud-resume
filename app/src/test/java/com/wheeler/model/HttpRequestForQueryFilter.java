package com.wheeler.model;

import com.microsoft.azure.functions.HttpRequestMessage;
import com.wheeler.dao.filter.QueryFilter;

import java.util.Optional;

public interface HttpRequestForQueryFilter extends HttpRequestMessage<Optional<QueryFilter>> {
}
